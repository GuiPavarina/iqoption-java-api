package org.guipavarina.iqoption.ws.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "body", "version", "name" })
public class Msg {

	@JsonProperty("body")
	private CandleBody body;
	@JsonProperty("version")
	private String version;
	@JsonProperty("name")
	private String name;

	public Msg(CandleBody body) {
		super();
		this.body = body;
		this.version = "2.0";
		this.name = "get-candles";
	}

	@JsonProperty("body")
	public CandleBody getBody() {
		return body;
	}

	@JsonProperty("body")
	public void setBody(CandleBody body) {
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