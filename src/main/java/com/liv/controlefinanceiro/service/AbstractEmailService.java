package com.liv.controlefinanceiro.service;

import org.springframework.mail.SimpleMailMessage;

import com.liv.controlefinanceiro.domain.TipoGasto;

public abstract class AbstractEmailService implements EmailService{

	@Override
	public void envioCadastroTipoGasto(TipoGasto tipoGasto) {
		SimpleMailMessage smm =  prepareSimpleMailMessageFromTipoGasto(tipoGasto);	
		envioEmail(smm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromTipoGasto(TipoGasto tipoGasto) {
		
		return null;
	}
}
