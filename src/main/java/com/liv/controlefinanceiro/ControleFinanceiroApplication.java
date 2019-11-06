package com.liv.controlefinanceiro;

import java.util.Arrays;

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
	
	@Autowired
	TipoGastoRepository tipoGastoRepository;
	
	@Autowired
	GastoMesRepository gastoMesRepository;

	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		TipoGasto tipo1 = new TipoGasto(null,"casa",true);
		TipoGasto tipo2 = new TipoGasto(null,"alimentacao",true);
		TipoGasto tipo3 = new TipoGasto(null,"diversão",false);
		
		
		
		GastoMes gt1 = new GastoMes(null,"financiamento", 10,2018,1600, TipoPagamentoEnum.DEBITO, 1, 1, tipo1);
		GastoMes gt2 = new GastoMes(null,"condominio",10,2018,400,TipoPagamentoEnum.DEBITO,1,1, tipo1);
		GastoMes gt3 = new GastoMes(null,"luz",10,2018,200,TipoPagamentoEnum.DINHEIRO,1,1, tipo1);
		GastoMes gt4 = new GastoMes(null,"supermercado",10,2018,400,TipoPagamentoEnum.DEBITO,1,1, tipo2);
		
		GastoMes gt5 = new GastoMes(null,"tenis",10,2018,100,TipoPagamentoEnum.CARTAO_PARCELADO,1,3, tipo3);
		GastoMes gt6 = new GastoMes(null,"tenis",11,2018,100,TipoPagamentoEnum.CARTAO_PARCELADO,2,3, tipo3);
		GastoMes gt7 = new GastoMes(null,"tenis",12,2018,100,TipoPagamentoEnum.CARTAO_PARCELADO,3,3, tipo3);
		
				
		tipoGastoRepository.saveAll(Arrays.asList(tipo1,tipo2,tipo3));
		
		gastoMesRepository.saveAll(Arrays.asList(gt1,gt2,gt3,gt4,gt5,gt6,gt7));
				
	}

}
