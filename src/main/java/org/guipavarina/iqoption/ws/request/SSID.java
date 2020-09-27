package org.guipavarina.iqoption.ws.request;

public class SSID {
		
	private String msg;
	private String name;
	private String request_id;
	
	public SSID(String msg) {
		super();
		this.msg = msg;
		this.name = "ssid";
		this.request_id = "";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

}
