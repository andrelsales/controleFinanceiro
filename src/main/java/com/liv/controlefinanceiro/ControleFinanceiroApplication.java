package com.liv.controlefinanceiro;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liv.controlefinanceiro.domain.GastoMes;
import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.domain.enums.TipoPagamentoEnum;
import com.liv.controlefinanceiro.repository.GastoMesRepository;
import com.liv.controlefinanceiro.repository.TipoGastoRepository;

@SpringBootApplication
public class ControleFinanceiroApplication implements CommandLineRunner {
	


	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		
	}

}
