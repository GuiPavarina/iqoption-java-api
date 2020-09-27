package org.guipavarina.iqoption.service;

import org.guipavarina.iqoption.rest.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public class LoginService extends Service {
	
	public ResponseEntity<String> login(String email, String password) {
		return restTemplate.postForEntity("https://auth.iqoption.com/api/v2/login",
				new LoginRequest(email, password), String.class);
	}

}
