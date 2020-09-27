package org.guipavarina.iqoption.ws.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "name", "msg", "request_id" })
public class ProfileRootMessage {

	@JsonProperty("name")
	private String name;
	@JsonProperty("msg")
	private ProfileResponse msg;
	@JsonProperty("request_id")
	private String requestId;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("msg")
	public ProfileResponse getMsg() {
		return msg;
	}

	@JsonProperty("msg")
	public void setMsg(ProfileResponse msg) {
		this.msg = msg;
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
		return "ProfileRootMessage [name=" + name + ", msg=" + msg + ", requestId=" + requestId + "]";
	}

}
