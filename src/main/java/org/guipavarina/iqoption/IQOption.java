package org.guipavarina.iqoption;

import java.net.URI;
import java.net.URISyntaxException;

import org.guipavarina.iqoption.enums.BalanceType;
import org.guipavarina.iqoption.event.EventListener;
import org.guipavarina.iqoption.event.EventManager;
import org.guipavarina.iqoption.event.Events;
import org.guipavarina.iqoption.factory.ResponseFactory;
import org.guipavarina.iqoption.service.LoginService;
import org.guipavarina.iqoption.ws.request.SSID;
import org.guipavarina.iqoption.ws.response.Balance;
import org.guipavarina.iqoption.ws.response.ProfileRootMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public class IQOption implements EventListener {

	private final Logger logger = LoggerFactory.getLogger(IQOption.class);

	private String email;
	private String password;

	private boolean isAuthenticated = false;

	private String ssid = "";
	private String cookies = "";

	private EventManager eventManager;
	
	private IQOptionWS webSocket;

	private LoginService loginService;
	
	public IQOption(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.eventManager = new EventManager();
		initServices();
		initListeners();
	}
	
	private void initServices() {
		this.loginService = new LoginService();
	}
	
	private void initListeners() {
		this.eventManager.subscribe(Events.PROFILE, this);
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	public EventManager getEventManager() {
		return this.eventManager;
	}

	public void connect() {
		ResponseEntity<String> res = null;
		try {
			res = loginService.login(email, password);
		} catch (RestClientException e) {
			logger.error(e.getMessage());
			logger.error("Could not login into IQOption.. Retrying");
			return;
		}
		
		if (res != null && HttpStatus.OK.equals(res.getStatusCode())) {
			this.cookies = res.getHeaders().get("Set-Cookie").get(0);
			this.isAuthenticated = true;
			this.ssid = this.cookies.substring(5, this.cookies.indexOf(';'));
			logger.info("Logged into IQOption rest api");
		}

		try {
			webSocket = new IQOptionWS(new URI("wss://iqoption.com/echo/websocket"));
			webSocket.addMessageHandler(new IQOptionMessageHandler(this.eventManager));
			
			if(!webSocket.getUserSession().isOpen()) {
				this.isAuthenticated = false;
				return;
			}

			webSocket.sendMessage(new SSID(ssid));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
	
	private void getActiveBalance(ProfileRootMessage profile) {
		Long id = profile.getMsg().getBalanceId();
		Balance balance = profile.getMsg().getBalances()
			.stream()
			.filter(b -> b.getId() == id)
			.findFirst().get();
		logger.info("Current balance is: " + BalanceType.get(balance.getType()));
		logger.info("Balance data: " + balance.toString());
	}
	
	public void sendWSMessage(Object obj) {
		webSocket.sendMessage(obj);
	}
	
	@Override
	public void update(Events ev, String message) {
		if(Events.PROFILE.equals(ev)) {
			ProfileRootMessage profile = (ProfileRootMessage) ResponseFactory.transform(Events.PROFILE, message);
			getActiveBalance(profile);
		}
	}

}
