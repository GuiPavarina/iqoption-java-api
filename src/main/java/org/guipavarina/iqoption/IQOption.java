package org.guipavarina.iqoption;

import java.net.URI;
import java.net.URISyntaxException;

import org.guipavarina.iqoption.service.LoginService;
import org.guipavarina.iqoption.ws.request.SSID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public class IQOption {

	private final Logger logger = LoggerFactory.getLogger(IQOption.class);

	private String email;
	private String password;

	private boolean isAuthenticated = false;

	private String ssid = "";
	private String cookies = "";

	private IQOptionWS webSocket;

	private LoginService loginService;
	
	public IQOption(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		initServices();
	}
	
	private void initServices() {
		this.loginService = new LoginService();
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
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
			webSocket.addMessageHandler(new IQOptionMessageHandler());
			
			if(!webSocket.getUserSession().isOpen()) {
				this.isAuthenticated = false;
				return;
			}

			webSocket.sendMessage(new SSID(ssid));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
	
	public void sendWSMessage(Object obj) {
		webSocket.sendMessage(obj);
	}

}
