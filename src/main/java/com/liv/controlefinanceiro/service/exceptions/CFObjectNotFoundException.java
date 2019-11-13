package com.liv.controlefinanceiro.service.exceptions;

public class CFObjectNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CFObjectNotFoundException(String mgs) {		
		super(mgs);
	}
	
	public CFObjectNotFoundException(String mgs, Throwable cause)
	{
		super(mgs, cause);		
	}
}
