package org.guipavarina.iqoption.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "balance", "balance_id", "balances", "name" })
public class ProfileResponse {

	@JsonProperty("balance")
	private Double balance;
	@JsonProperty("balance_id")
	private Long balanceId;
	@JsonProperty("balances")
	private List<Balance> balances = null;
	@JsonProperty("name")
	private String name;

	@JsonProperty("balance")
	public Double getBalance() {
		return balance;
	}

	@JsonProperty("balance")
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@JsonProperty("balance_id")
	public Long getBalanceId() {
		return balanceId;
	}

	@JsonProperty("balance_id")
	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	@JsonProperty("balances")
	public List<Balance> getBalances() {
		return balances;
	}

	@JsonProperty("balances")
	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProfileResponse [balance=" + balance + ", balanceId=" + balanceId + ", balances=" + balances + ", name="
				+ name + "]";
	}


}