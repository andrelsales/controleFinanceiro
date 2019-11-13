package com.liv.controlefinanceiro.dto;

import java.io.Serializable;

public class EmailDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	
	public EmailDto() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
