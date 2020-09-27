package org.guipavarina.iqoption.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeBalanceRequest {
	
	@JsonProperty("balance_id")
	private Long balanceId;

	public ChangeBalanceRequest(Long balanceId) {
		super();
		this.balanceId = balanceId;
	}

	public Long getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

}
