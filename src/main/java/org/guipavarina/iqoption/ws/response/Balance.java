package org.guipavarina.iqoption.ws.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id", "user_id", "type", "amount", "enrolled_amount", "enrolled_sum_amount", "hold_amount",
		"orders_amount", "auth_amount", "equivalent", "currency", "tournament_id", "tournament_name", "is_fiat",
		"is_marginal", "has_deposits" })
public class Balance {

	@JsonProperty("id")
	private long id;
	@JsonProperty("user_id")
	private long userId;
	@JsonProperty("type")
	private Integer type;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("enrolled_amount")
	private Integer enrolledAmount;
	@JsonProperty("enrolled_sum_amount")
	private Integer enrolledSumAmount;
	@JsonProperty("hold_amount")
	private Integer holdAmount;
	@JsonProperty("orders_amount")
	private Integer ordersAmount;
	@JsonProperty("auth_amount")
	private Integer authAmount;
	@JsonProperty("equivalent")
	private Integer equivalent;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("tournament_id")
	private Object tournamentId;
	@JsonProperty("tournament_name")
	private Object tournamentName;
	@JsonProperty("is_fiat")
	private Boolean isFiat;
	@JsonProperty("is_marginal")
	private Boolean isMarginal;
	@JsonProperty("has_deposits")
	private Boolean hasDeposits;

	@JsonProperty("id")
	public long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("user_id")
	public long getUserId() {
		return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@JsonProperty("type")
	public Integer getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(Integer type) {
		this.type = type;
	}

	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@JsonProperty("enrolled_amount")
	public Integer getEnrolledAmount() {
		return enrolledAmount;
	}

	@JsonProperty("enrolled_amount")
	public void setEnrolledAmount(Integer enrolledAmount) {
		this.enrolledAmount = enrolledAmount;
	}

	@JsonProperty("enrolled_sum_amount")
	public Integer getEnrolledSumAmount() {
		return enrolledSumAmount;
	}

	@JsonProperty("enrolled_sum_amount")
	public void setEnrolledSumAmount(Integer enrolledSumAmount) {
		this.enrolledSumAmount = enrolledSumAmount;
	}

	@JsonProperty("hold_amount")
	public Integer getHoldAmount() {
		return holdAmount;
	}

	@JsonProperty("hold_amount")
	public void setHoldAmount(Integer holdAmount) {
		this.holdAmount = holdAmount;
	}

	@JsonProperty("orders_amount")
	public Integer getOrdersAmount() {
		return ordersAmount;
	}

	@JsonProperty("orders_amount")
	public void setOrdersAmount(Integer ordersAmount) {
		this.ordersAmount = ordersAmount;
	}

	@JsonProperty("auth_amount")
	public Integer getAuthAmount() {
		return authAmount;
	}

	@JsonProperty("auth_amount")
	public void setAuthAmount(Integer authAmount) {
		this.authAmount = authAmount;
	}

	@JsonProperty("equivalent")
	public Integer getEquivalent() {
		return equivalent;
	}

	@JsonProperty("equivalent")
	public void setEquivalent(Integer equivalent) {
		this.equivalent = equivalent;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("tournament_id")
	public Object getTournamentId() {
		return tournamentId;
	}

	@JsonProperty("tournament_id")
	public void setTournamentId(Object tournamentId) {
		this.tournamentId = tournamentId;
	}

	@JsonProperty("tournament_name")
	public Object getTournamentName() {
		return tournamentName;
	}

	@JsonProperty("tournament_name")
	public void setTournamentName(Object tournamentName) {
		this.tournamentName = tournamentName;
	}

	@JsonProperty("is_fiat")
	public Boolean getIsFiat() {
		return isFiat;
	}

	@JsonProperty("is_fiat")
	public void setIsFiat(Boolean isFiat) {
		this.isFiat = isFiat;
	}

	@JsonProperty("is_marginal")
	public Boolean getIsMarginal() {
		return isMarginal;
	}

	@JsonProperty("is_marginal")
	public void setIsMarginal(Boolean isMarginal) {
		this.isMarginal = isMarginal;
	}

	@JsonProperty("has_deposits")
	public Boolean getHasDeposits() {
		return hasDeposits;
	}

	@JsonProperty("has_deposits")
	public void setHasDeposits(Boolean hasDeposits) {
		this.hasDeposits = hasDeposits;
	}

	@Override
	public String toString() {
		return "Balance [id=" + id + ", userId=" + userId + ", type=" + type + ", amount=" + amount
				+ ", enrolledAmount=" + enrolledAmount + ", enrolledSumAmount=" + enrolledSumAmount + ", holdAmount="
				+ holdAmount + ", ordersAmount=" + ordersAmount + ", authAmount=" + authAmount + ", equivalent="
				+ equivalent + ", currency=" + currency + ", tournamentId=" + tournamentId + ", tournamentName="
				+ tournamentName + ", isFiat=" + isFiat + ", isMarginal=" + isMarginal + ", hasDeposits=" + hasDeposits
				+ "]";
	}

}
