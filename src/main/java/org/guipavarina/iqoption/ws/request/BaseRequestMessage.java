package org.guipavarina.iqoption.ws.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "msg", "name", "request_id" })
public class BaseRequestMessage<T> {

	@JsonProperty("msg")
	private T msg;
	@JsonProperty("name")
	private String name;
	@JsonProperty("request_id")
	private String requestId;
	
	public BaseRequestMessage(String name, String requestId,T msg) {
		this.name = name;
		this.requestId = requestId;
		this.msg = msg;
	}

	@JsonProperty("msg")
	public T getMsg() {
		return msg;
	}

	@JsonProperty("msg")
	public void setMsg(T msg) {
		this.msg = msg;
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

}



