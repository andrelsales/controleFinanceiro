package com.liv.controlefinanceiro.service.exceptions;

public class CfObjectNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CfObjectNotFoundException(String mgs) {		
		super(mgs);
	}
	
	public CfObjectNotFoundException(String mgs, Throwable cause)
	{
		super(mgs, cause);		
	}
}
