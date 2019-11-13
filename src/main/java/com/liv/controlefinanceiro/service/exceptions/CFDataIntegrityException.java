package com.liv.controlefinanceiro.service.exceptions;

public class CFDataIntegrityException extends Exception{

	private static final long serialVersionUID = 1L;

	public CFDataIntegrityException(String mgs) {		
		super(mgs);
	}
	
	public CFDataIntegrityException(String mgs, Throwable cause)
	{
		super(mgs, cause);		
	}
}
