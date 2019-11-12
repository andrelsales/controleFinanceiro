package com.liv.controlefinanceiro.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.liv.controlefinanceiro.service.DbService;
import com.liv.controlefinanceiro.service.EmailService;
import com.liv.controlefinanceiro.service.MockEmailService;

@Configuration
@Profile("teste")
public class TesteConfig {

	@Autowired
	DbService dbService;
	
	@Bean
	public EmailService EmailService()
	{
		return new MockEmailService();
	}
	
	
	@Bean
	public Boolean instantiateDatabase() throws ParseException
	{
		dbService.instantiateTesteDataBase();
		return true;
	}
	
}
