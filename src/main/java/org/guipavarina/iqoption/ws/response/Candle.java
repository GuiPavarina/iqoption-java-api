package org.guipavarina.iqoption.ws.response;

import org.guipavarina.iqoption.enums.CandleDirection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "from", "min", "max", "volume", "to", "at", "close", "open", "id" })
public class Candle {

	@JsonProperty("from")
	private Integer from;
	@JsonProperty("min")
	private Double min;
	@JsonProperty("max")
	private Double max;
	@JsonProperty("volume")
	private Integer volume;
	@JsonProperty("to")
	private Integer to;
	@JsonProperty("at")
	private Long at;
	@JsonProperty("close")
	private Double close;
	@JsonProperty("open")
	private Double open;
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("from")
	public Integer getFrom() {
		return from;
	}

	@JsonProperty("from")
	public void setFrom(Integer from) {
		this.from = from;
	}

	@JsonProperty("min")
	public Double getMin() {
		return min;
	}

	@JsonProperty("min")
	public void setMin(Double min) {
		this.min = min;
	}

	@JsonProperty("max")
	public Double getMax() {
		return max;
	}

	@JsonProperty("max")
	public void setMax(Double max) {
		this.max = max;
	}

	@JsonProperty("volume")
	public Integer getVolume() {
		return volume;
	}

	@JsonProperty("volume")
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@JsonProperty("to")
	public Integer getTo() {
		return to;
	}

	@JsonProperty("to")
	public void setTo(Integer to) {
		this.to = to;
	}

	@JsonProperty("at")
	public Long getAt() {
		return at;
	}

	@JsonProperty("at")
	public void setAt(Long at) {
		this.at = at;
	}

	@JsonProperty("close")
	public Double getClose() {
		return close;
	}

	@JsonProperty("close")
	public void setClose(Double close) {
		this.close = close;
	}

	@JsonProperty("open")
	public Double getOpen() {
		return open;
	}

	@JsonProperty("open")
	public void setOpen(Double open) {
		this.open = open;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CandleDirection getDirection() {
		if(getClose() > getOpen()) {
			return CandleDirection.UP;
		} else if (getClose() == getOpen()) {
			return CandleDirection.DRAW;
		} else {
			return CandleDirection.DOWN;
		}
	}

	@Override
	public String toString() {
		return "Candle [from=" + from + ", min=" + min + ", max=" + max + ", volume=" + volume + ", to=" + to + ", at="
				+ at + ", close=" + close + ", open=" + open + ", id=" + id + "]";
	}	

}