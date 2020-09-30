package org.guipavarina.iqoption.ws.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "body", "version", "name" })
public class Msg<T> {

	@JsonProperty("body")
	private T body;
	@JsonProperty("version")
	private String version;
	@JsonProperty("name")
	private String name;

	public Msg(String name, String version, T body) {
		super();
		this.body = body;
		this.version = version;
		this.name = name;
	}

	@JsonProperty("body")
	public T getBody() {
		return body;
	}

	@JsonProperty("body")
	public void setBody(T body) {
		this.body = body;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

}