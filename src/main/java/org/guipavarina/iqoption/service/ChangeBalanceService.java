package org.guipavarina.iqoption.service;

import org.guipavarina.iqoption.rest.request.ChangeBalanceRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ChangeBalanceService extends Service {

	public ResponseEntity<String> changeBalance(Long id, String cookies) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.COOKIE, "ssid=" + cookies);

		HttpEntity<String> entity = new HttpEntity(new ChangeBalanceRequest(id), headers);
		return restTemplate.postForEntity("https://iqoption.com/api/profile/changebalance",
				entity , String.class);
		
	}
	
}
