package com.liv.controlefinanceiro.service.exceptions;

public class CfDataIntegrityException extends Exception{

	private static final long serialVersionUID = 1L;

	public CfDataIntegrityException(String mgs) {		
		super(mgs);
	}
	
	public CfDataIntegrityException(String mgs, Throwable cause)
	{
		super(mgs, cause);		
	}
}
