package com.liv.controlefinanceiro.service;

import org.springframework.mail.SimpleMailMessage;

import com.liv.controlefinanceiro.domain.TipoGasto;

public interface EmailService {
	
	void envioCadastroTipoGasto(TipoGasto tipoGasto);

	void envioEmail(SimpleMailMessage mgs);
}
