package com.liv.controlefinanceiro.service;


import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService{
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void envioEmail(SimpleMailMessage mgs) {
		
		LOG.info("SIMULANDO ENVIO DE E-MAIL");
		LOG.info(mgs.getText());
		LOG.info("E-MAIL ENVIADO");
	}

	@Override
	public void envioHtmlEmail(MimeMessage msg) {
	
		LOG.info("SIMULANDO ENVIO DE E-MAIL HTML");
		LOG.info(msg.toString());
		LOG.info("E-MAIL HTML ENVIADO ");
		
	}

}
