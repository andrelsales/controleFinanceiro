package com.liv.controlefinanceiro.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.resources.exception.FieldMessagem;

public class TipoGastoValidator implements ConstraintValidator<TipoGastoInsert,TipoGasto> {
	
	@Override
	public	void initialize(TipoGastoInsert ann) {
	}

	@Override
	public boolean isValid(TipoGasto tipo, ConstraintValidatorContext context) {
		List<FieldMessagem> list = new ArrayList<>();

		if (tipo.getNome().startsWith("Z")) {			
			list.add(new FieldMessagem("nome","nome não pode começar com começar com Z"));
		}  
				
		for (FieldMessagem e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}