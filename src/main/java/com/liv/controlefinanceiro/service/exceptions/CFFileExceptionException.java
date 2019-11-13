package com.liv.controlefinanceiro.service.exceptions;

public class CFFileExceptionException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CFFileExceptionException(String mgs) {		
		super(mgs);
	}
	
	public CFFileExceptionException(String mgs, Throwable cause)
	{
		super(mgs, cause);		
	}
}
