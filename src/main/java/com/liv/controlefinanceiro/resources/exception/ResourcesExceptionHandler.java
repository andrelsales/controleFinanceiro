package com.liv.controlefinanceiro.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.liv.controlefinanceiro.service.exceptions.CfDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(CfObjectNotFoundException.class)
	public ResponseEntity<StantardError> cpObjectNotFound(CfObjectNotFoundException e, HttpServletRequest request) {

		StantardError erro = new StantardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(CfDataIntegrityException.class)
	public ResponseEntity<StantardError> dataIntegrity(CfDataIntegrityException e, HttpServletRequest http)
	{
		StantardError erro = new StantardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StantardError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest http)
	{
		ValidationError erro = new ValidationError(HttpStatus.BAD_REQUEST.value(), "ERRO DE VALIDAÇÃO", System.currentTimeMillis());
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {			
			erro.addError(x.getField(),x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);		
	}
	
	
}
