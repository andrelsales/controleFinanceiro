package com.liv.controlefinanceiro.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.liv.controlefinanceiro.domain.Cliente;
import com.liv.controlefinanceiro.domain.TipoGasto;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Value("${default.recipient}")
	private String recipient;
	
	@Autowired
	private TemplateEngine templateEngine; 
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void envioCadastroTipoGasto(TipoGasto tipoGasto) {
		SimpleMailMessage smm =  prepareSimpleMailMessageFromTipoGasto(tipoGasto);	
		envioEmail(smm);
	}
	
	@Override
	public void envioCadastroTipoGastoHtmlEmail(TipoGasto tipoGasto)
	{		
		MimeMessage mm;
		try {
			mm = prepareMimeMessageFromTipoGasto(tipoGasto);
			envioHtmlEmail(mm);
		} catch (MessagingException e) {
			envioCadastroTipoGasto(tipoGasto);
			e.printStackTrace();
		}		
	}

	protected MimeMessage prepareMimeMessageFromTipoGasto(TipoGasto tipoGasto) throws MessagingException {
	
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(recipient);
		mmh.setFrom(sender);
		mmh.setSubject("Tipo Gasto cadastrado : " + tipoGasto.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateTipoGasto(tipoGasto),true);
		
		
		return mimeMessage;
		
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromTipoGasto(TipoGasto tipoGasto) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(recipient);
		smm.setFrom(sender);
		smm.setSubject("Tipo gasto cadastrado :" + tipoGasto.getNome());
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText(tipoGasto.toString());
		return smm;
	}
	
	protected String htmlFromTemplateTipoGasto(TipoGasto tipoGasto)
	{
		Context context = new Context();
		context.setVariable("tipo", tipoGasto);
		return templateEngine.process("email/confirmacaoTipoGasto", context);		
	}
	
	@Override
	public void sendEmailComNovaSenha(Cliente cliente, String novaSenha)
	{
		SimpleMailMessage smm =  prepareEmailNovaSenha(cliente, novaSenha);	
		envioEmail(smm);
		
	}

	protected SimpleMailMessage prepareEmailNovaSenha(Cliente cliente, String novaSenha) {
		
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(cliente.getEmail());
		smm.setFrom(sender);
		smm.setSubject("Solicitação de nova senha");
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText("Nova senha : " + novaSenha);
		return smm;
	}
	
}
