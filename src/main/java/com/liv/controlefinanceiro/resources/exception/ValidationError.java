package com.liv.controlefinanceiro.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StantardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessagem> lista = new ArrayList<FieldMessagem>();
	
	public ValidationError(Integer status, String mgs, Long timeStamp) {
		super(status, mgs, timeStamp);	
	}

	public List<FieldMessagem> getError() {
		return lista;
	}

	public void addError(String fieldName, String message) {
		this.lista.add(new FieldMessagem(fieldName, message));
	}
	
}
