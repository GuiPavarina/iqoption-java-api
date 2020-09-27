package org.guipavarina.iqoption.service;

import org.springframework.web.client.RestTemplate;

public abstract class Service {
	
	protected RestTemplate restTemplate;
	
	public Service() {
		this.restTemplate = new RestTemplate();
	}

}
