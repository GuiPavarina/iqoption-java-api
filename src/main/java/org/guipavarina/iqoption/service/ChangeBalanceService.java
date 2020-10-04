package org.guipavarina.iqoption.service;

import org.guipavarina.iqoption.rest.request.ChangeBalanceRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ChangeBalanceService extends Service {

	/**
	 * Change active balance by its id
	 * @param id
	 * @param headers
	 * @return ResponseEntity
	 */
	public ResponseEntity<String> changeBalance(Long id, HttpHeaders headers) {
		HttpEntity<String> entity = new HttpEntity(new ChangeBalanceRequest(id), headers);
		return restTemplate.postForEntity("https://iqoption.com/api/profile/changebalance",
				entity , String.class);
	}
	
}
