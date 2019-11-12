package com.liv.controlefinanceiro.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.liv.controlefinanceiro.domain.TipoGasto;

public interface EmailService {
	
	void envioCadastroTipoGasto(TipoGasto tipoGasto);

	void envioEmail(SimpleMailMessage mgs);
	
	void envioCadastroTipoGastoHtmlEmail(TipoGasto tipoGasto);
	
	void envioHtmlEmail(MimeMessage msg);
}
