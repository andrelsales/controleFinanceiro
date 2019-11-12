package com.liv.controlefinanceiro.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class SmtpEmailService extends AbstractEmailService {

	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	
	@Autowired 
	private JavaMailSender sender;
	
	@Override
	public void envioEmail(SimpleMailMessage mgs) {
		
		LOG.info("SIMULANDO ENVIO DE E-MAIL");
		sender.send(mgs);
		LOG.info("E-MAIL ENVIADO");
		
	}

	@Override
	public void envioHtmlEmail(MimeMessage msg) {
	
		LOG.info("SIMULANDO ENVIO DE E-MAIL HTML");
		sender.send(msg);
		LOG.info("E-MAIL ENVIADO");
		
	}

}
