package com.bookyourticket.dto;

public class RegistrationInfo {

	private String name;
	private String email;

	public RegistrationInfo() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationInfo(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegistrationInfo [name=" + name + ", email=" + email + "]";
	}

}
