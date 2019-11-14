package com.liv.controlefinanceiro.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StantardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessagem> lista = new ArrayList<FieldMessagem>();

	public ValidationError(Long timeStamp, Integer status, String error, String messagem, String path) {
		super(timeStamp, status, error, messagem, path);

	}

	public List<FieldMessagem> getError() {
		return lista;
	}

	public void addError(String fieldName, String message) {
		this.lista.add(new FieldMessagem(fieldName, message));
	}

}
