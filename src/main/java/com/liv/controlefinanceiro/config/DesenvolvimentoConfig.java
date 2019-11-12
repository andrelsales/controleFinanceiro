package com.liv.controlefinanceiro.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.liv.controlefinanceiro.service.DbService;
import com.liv.controlefinanceiro.service.EmailService;
import com.liv.controlefinanceiro.service.MockEmailService;
import com.liv.controlefinanceiro.service.SmtpEmailService;

@Configuration
@Profile("desenvolvimento")
public class DesenvolvimentoConfig {

	@Autowired
	DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}") 
	String criacao_banco;
	
	@Bean
	public Boolean instantiateDatabase() throws ParseException
	{		
		if (!criacao_banco.equals("create")) {			
			return false;			
		}		
		dbService.instantiateTesteDataBase();
		return true;
	}
	
	@Bean
	public EmailService EmailService()
	{
		return new SmtpEmailService();
	}
	
}
