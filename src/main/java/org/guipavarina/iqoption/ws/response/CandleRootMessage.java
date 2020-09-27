package org.guipavarina.iqoption.ws.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "msg", "status", "name", "request_id" })
public class CandleRootMessage {

	@JsonProperty("msg")
	private CandlesResponse msg;
	@JsonProperty("status")
	private Integer status;
	@JsonProperty("name")
	private String name;
	@JsonProperty("request_id")
	private String requestId;

	@JsonProperty("msg")
	public CandlesResponse getMsg() {
		return msg;
	}

	@JsonProperty("msg")
	public void setMsg(CandlesResponse msg) {
		this.msg = msg;
	}

	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("request_id")
	public String getRequestId() {
		return requestId;
	}

	@JsonProperty("request_id")
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "CandleRootMessage [msg=" + msg + ", status=" + status + ", name=" + name + ", requestId=" + requestId
				+ "]";
	}

}



