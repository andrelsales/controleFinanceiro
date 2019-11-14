package com.liv.controlefinanceiro.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.liv.controlefinanceiro.service.exceptions.CFAuthorizationException;
import com.liv.controlefinanceiro.service.exceptions.CFDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CFFileExceptionException;
import com.liv.controlefinanceiro.service.exceptions.CFObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(CFObjectNotFoundException.class)
	public ResponseEntity<StantardError> cpObjectNotFound(CFObjectNotFoundException e, HttpServletRequest request) {

		StantardError erro = new StantardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"não encontrado ", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(CFDataIntegrityException.class)
	public ResponseEntity<StantardError> dataIntegrity(CFDataIntegrityException e, HttpServletRequest request) {

		StantardError erro = new StantardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"integridade de dados  ", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StantardError> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		ValidationError erro = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"erro de validação  ", e.getMessage(), request.getRequestURI());

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}

	@ExceptionHandler(CFAuthorizationException.class)
	public ResponseEntity<StantardError> Authorization(CFAuthorizationException e, HttpServletRequest request) {

		StantardError erro = new StantardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
				"acesso negado  ", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}

	@ExceptionHandler(CFFileExceptionException.class)
	public ResponseEntity<StantardError> file(CFFileExceptionException e, HttpServletRequest request) {

		StantardError erro = new StantardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"erro de Arquivo  ", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StantardError> amazonService(AmazonServiceException e, HttpServletRequest request) {
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());

		StantardError erro = new StantardError(System.currentTimeMillis(), code.value(), "erro Amazon Servoce  ",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(code).body(erro);
	}

	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StantardError> amazonCliente(AmazonClientException e, HttpServletRequest request) {

		StantardError erro = new StantardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"erro Amazon Client  ", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StantardError> amazonS3(AmazonS3Exception e, HttpServletRequest request) {

		StantardError erro = new StantardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "erro S3  ",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
