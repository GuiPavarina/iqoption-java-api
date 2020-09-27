package org.guipavarina.iqoption.ws.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "count", "to", "size", "active_id" })
public class CandleBody {

	@JsonProperty("count")
	private Integer count;
	@JsonProperty("to")
	private Integer to;
	@JsonProperty("size")
	private Integer size;
	@JsonProperty("active_id")
	private Integer activeId;
	
	public CandleBody(Integer count, Integer to, Integer size, Integer activeId) {
		super();
		this.count = count;
		this.to = to;
		this.size = size;
		this.activeId = activeId;
	}

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("to")
	public Integer getTo() {
		return to;
	}

	@JsonProperty("to")
	public void setTo(Integer to) {
		this.to = to;
	}

	@JsonProperty("size")
	public Integer getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(Integer size) {
		this.size = size;
	}

	@JsonProperty("active_id")
	public Integer getActiveId() {
		return activeId;
	}

	@JsonProperty("active_id")
	public void setActiveId(Integer activeId) {
		this.activeId = activeId;
	}

}
