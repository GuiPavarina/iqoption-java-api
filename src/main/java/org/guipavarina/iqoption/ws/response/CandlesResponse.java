package org.guipavarina.iqoption.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "candles" })
public class CandlesResponse {

	@JsonProperty("candles")
	private List<Candle> candles = null;

	@JsonProperty("candles")
	public List<Candle> getCandles() {
		return candles;
	}

	@JsonProperty("candles")
	public void setCandles(List<Candle> candles) {
		this.candles = candles;
	}

	@Override
	public String toString() {
		return "CandlesResponse [candles=" + candles + "]";
	}

}