package org.guipavarina.iqoption;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.guipavarina.iqoption.enums.Actives;
import org.guipavarina.iqoption.enums.BalanceType;
import org.guipavarina.iqoption.event.EventListener;
import org.guipavarina.iqoption.event.EventManager;
import org.guipavarina.iqoption.event.Events;
import org.guipavarina.iqoption.factory.ResponseFactory;
import org.guipavarina.iqoption.service.ChangeBalanceService;
import org.guipavarina.iqoption.service.LoginService;
import org.guipavarina.iqoption.ws.request.BaseRequestMessage;
import org.guipavarina.iqoption.ws.request.CandleBody;
import org.guipavarina.iqoption.ws.request.Msg;
import org.guipavarina.iqoption.ws.response.Balance;
import org.guipavarina.iqoption.ws.response.ProfileRootMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public class IQOption implements EventListener {

	private final Logger logger = LoggerFactory.getLogger(IQOption.class);

	/*
	 * Authentication
	 */
	private String email;
	private String password;

	private boolean isAuthenticated = false;

	private String ssid = "";
	private String cookies = "";
	
	private HttpHeaders headers;
	
	/**
	 * Profile
	 */
	private List<Balance> balances;

	/**
	 * Event Manager
	 */
	private EventManager eventManager;
	
	/*
	 * Web Socket
	 */
	private IQOptionWS webSocket;

	/*
	 * Services
	 */
	private LoginService loginService;
	private ChangeBalanceService changeBalanceService;
	
	public IQOption(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.headers = new HttpHeaders();
		this.eventManager = new EventManager();
		initServices();
		initListeners();
	}
	
	private void initServices() {
		this.loginService = new LoginService();
		this.changeBalanceService = new ChangeBalanceService();
	}
	
	private void initListeners() {
		this.eventManager.subscribe(Events.PROFILE, this);
	}

	/**
	 * check if websocket and api are fine
	 * if it returns false, one of them may have failed
	 * @return
	 */
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	/**
	 * Gets the EventManager for this IQOption instance.
	 * It should be used to subscribe to events.
	 * @return instance of the EventManager
	 */
	public EventManager getEventManager() {
		return this.eventManager;
	}

	/**
	 * Connect to both api and websocket
	 */
	public void connect() {
		ResponseEntity<String> res = null;
		try {
			res = loginService.login(email, password);
		} catch (RestClientException e) {
			logger.error(e.getMessage());
			logger.error("Could not login into IQOption..");
			return;
		}
		
		if (res != null && HttpStatus.OK.equals(res.getStatusCode())) {
			this.cookies = res.getHeaders().get("Set-Cookie").get(0);
			this.isAuthenticated = true;
			this.ssid = this.cookies.substring(5, this.cookies.indexOf(';'));
			this.headers.set(HttpHeaders.COOKIE, "ssid=" + cookies);
			logger.info("Logged into IQOption rest api");
		}

		try {
			webSocket = new IQOptionWS(new URI("wss://iqoption.com/echo/websocket"));
			webSocket.addMessageHandler(new IQOptionMessageHandler(this.eventManager));
			
			if(!webSocket.getUserSession().isOpen()) {
				this.isAuthenticated = false;
				return;
			}

			webSocket.sendMessage(new BaseRequestMessage<String>("ssid", "", ssid));
		} catch (URISyntaxException e) {
			logger.error(e.getMessage());
		}

	}
	
	/**
	 * Method used to get the current balance.
	 * REAL or PRACTICE account
	 * @param profile
	 */
	private void getActiveBalance(ProfileRootMessage profile) {
		Long id = profile.getMsg().getBalanceId();
		Balance balance = profile.getMsg().getBalances()
			.stream()
			.filter(b -> b.getId() == id)
			.findFirst().get();
		logger.info("Current balance is: " + BalanceType.get(balance.getType()));
		balances = profile.getMsg().getBalances();
	}
	
	/*
	 * ------------------------------------------------ 
	 *           Web Socket methods
	 * ------------------------------------------------
	 */
	
	/**
	 * Method to get candles
	 * !!Subscribe to the Events.CANDLE to get the response!!
	 * 
	 * IQUtils.getCurrentTime() to get the current time in seconds
	 * 
	 * @param count -  number of candles
	 * @param to - current time in seconds
	 * @param size - size in seconds of each candle  
	 * @param activeid - id of the ticker
	 */
	public void getCandles(int count, long to, int size,  Actives active ) {
		CandleBody body = new CandleBody(count, to, size, active.getId());
		webSocket.sendMessage(new BaseRequestMessage<Msg<CandleBody>>("sendMessage", "", new Msg<CandleBody>("get-candles", "2.0", body)));
	}
	
	/**
	 * !!Subscribe to Events.INITIALIZATION_DATA to get the response!!
	 * 
	 * This method returns a huge amount of data with all binary active 
	 * and its info.
	 */
	public void getAllBinaryData() {
		webSocket.sendMessage(new BaseRequestMessage<Msg<Object>>("sendMessage", "", new Msg<Object>("get-initialization-data", "3.0", new Object())));
	}
	
	/*
	 * ------------------------------------------------ 
	 *          END of Web Socket methods
	 * ------------------------------------------------
	 */
	
	/*
	 * ------------------------------------------------ 
	 *           REST API methods
	 * ------------------------------------------------
	 */
	
	
	/**
	 * Change balance type
	 * Check BalanceType for reference
	 * @param type
	 * @return Response Entity
	 */
	public ResponseEntity<String> changeBalance(BalanceType type) {
		Balance balance = balances
				.stream()
				.filter(b -> b.getType() == type.getId())
				.findFirst().get();
		return changeBalanceService.changeBalance(balance.getId(), this.headers);
	}
	
	/*
	 * ------------------------------------------------ 
	 *           End of REST API methods
	 * ------------------------------------------------
	 */
	
	@Override
	public void update(Events ev, String message) {
		if(Events.PROFILE.equals(ev)) {
			ProfileRootMessage profile = (ProfileRootMessage) ResponseFactory.transform(Events.PROFILE, message);
			getActiveBalance(profile);
		}
	}

}
