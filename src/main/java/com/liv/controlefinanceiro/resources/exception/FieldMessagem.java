package com.liv.controlefinanceiro.resources.exception;

import java.io.Serializable;

public class FieldMessagem implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	
	public FieldMessagem() {
		
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FieldMessagem(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	

}
