package com.liv.controlefinanceiro.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.liv.controlefinanceiro.service.DbService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Autowired
	DbService dbService;
	
	@Bean
	public Boolean instantiateDatabase() throws ParseException
	{
		dbService.instantiateTesteDataBase();
		return true;
	}
	
}
