package org.guipavarina.iqoption.rest.request;

public class LoginRequest {

	private String identifier;
	private String password;
	
	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginRequest(String identifier, String password) {
		super();
		this.identifier = identifier;
		this.password = password;
	}

	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
