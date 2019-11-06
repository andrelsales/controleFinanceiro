package com.liv.controlefinanceiro.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(CfObjectNotFoundException.class)
	public ResponseEntity<StantardError> cpObjectNotFound(CfObjectNotFoundException e, HttpServletRequest request) {

		StantardError erro = new StantardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}