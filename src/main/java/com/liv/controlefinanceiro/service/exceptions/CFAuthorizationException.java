package com.liv.controlefinanceiro.service.exceptions;

public class CFAuthorizationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CFAuthorizationException(String mgs) {		
		super(mgs);
	}
	
	public CFAuthorizationException(String mgs, Throwable cause)
	{
		super(mgs, cause);		
	}
}
