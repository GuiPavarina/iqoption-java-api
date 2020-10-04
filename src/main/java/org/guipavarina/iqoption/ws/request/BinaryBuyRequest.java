package org.guipavarina.iqoption.ws.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "option_type_id", "direction", "price", "user_balance_id", "expired", "active_id" })
public class BinaryBuyRequest {

	@JsonProperty("option_type_id")
	private int optionTypeId;
	@JsonProperty("direction")
	private String direction;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("user_balance_id")
	private Long userBalanceId;
	@JsonProperty("expired")
	private Long expired;
	@JsonProperty("active_id")
	private int activeId;
	
	public BinaryBuyRequest(int optionTypeId, String direction, Double price, Long userBalanceId, Long expired,
			int activeId) {
		super();
		this.optionTypeId = optionTypeId;
		this.direction = direction;
		this.price = price;
		this.userBalanceId = userBalanceId;
		this.expired = expired;
		this.activeId = activeId;
	}

	@JsonProperty("option_type_id")
	public int getOptionTypeId() {
		return optionTypeId;
	}

	@JsonProperty("option_type_id")
	public void setOptionTypeId(int optionTypeId) {
		this.optionTypeId = optionTypeId;
	}

	@JsonProperty("direction")
	public String getDirection() {
		return direction;
	}

	@JsonProperty("direction")
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonProperty("user_balance_id")
	public Long getUserBalanceId() {
		return userBalanceId;
	}

	@JsonProperty("user_balance_id")
	public void setUserBalanceId(Long userBalanceId) {
		this.userBalanceId = userBalanceId;
	}

	@JsonProperty("expired")
	public Long getExpired() {
		return expired;
	}

	@JsonProperty("expired")
	public void setExpired(Long expired) {
		this.expired = expired;
	}

	@JsonProperty("active_id")
	public int getActiveId() {
		return activeId;
	}

	@JsonProperty("active_id")
	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}

	@Override
	public String toString() {
		return "BinaryBuyRequest [optionTypeId=" + optionTypeId + ", direction=" + direction + ", price=" + price
				+ ", userBalanceId=" + userBalanceId + ", expired=" + expired + ", activeId=" + activeId + "]";
	}

}