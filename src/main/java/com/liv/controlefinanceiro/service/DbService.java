package com.liv.controlefinanceiro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.liv.controlefinanceiro.domain.Cliente;
import com.liv.controlefinanceiro.domain.GastoMes;
import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.domain.enums.PerfilEnum;
import com.liv.controlefinanceiro.domain.enums.TipoPagamentoEnum;
import com.liv.controlefinanceiro.repository.ClienteRepository;
import com.liv.controlefinanceiro.repository.GastoMesRepository;
import com.liv.controlefinanceiro.repository.TipoGastoRepository;

@Service
public class DbService {
	
	@Autowired
	TipoGastoRepository tipoGastoRepository;
	
	@Autowired
	GastoMesRepository gastoMesRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTesteDataBase() throws ParseException
	{

		TipoGasto tipo1 = new TipoGasto(null,"casa",true);
		TipoGasto tipo2 = new TipoGasto(null,"alimentacao",true);
		TipoGasto tipo3 = new TipoGasto(null,"diversão",false);
		
		TipoGasto tipo4 = new TipoGasto(null,"carro",true);
		TipoGasto tipo5 = new TipoGasto(null,"saude",true);
		TipoGasto tipo6 = new TipoGasto(null,"cachorro",false);
		
		TipoGasto tipo7 = new TipoGasto(null,"esporte",true);
		TipoGasto tipo8 = new TipoGasto(null,"vestuário",true);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
		
		GastoMes gt1 = new GastoMes(null,"financiamento", 10,2018,1600, TipoPagamentoEnum.DEBITO, 1, 1, tipo1,new Date(),sdf.parse("20/12/2018 10:32"));
		GastoMes gt2 = new GastoMes(null,"condominio",10,2018,400,TipoPagamentoEnum.DEBITO,1,1, tipo1,new Date(),sdf.parse("20/09/2018 10:32"));
		GastoMes gt3 = new GastoMes(null,"luz",10,2018,200,TipoPagamentoEnum.DINHEIRO,1,1, tipo1,new Date(),sdf.parse("20/09/2018 10:32"));
		GastoMes gt4 = new GastoMes(null,"supermercado",10,2018,400,TipoPagamentoEnum.DEBITO,1,1, tipo2,new Date(),sdf.parse("20/09/2018 10:32"));
		
		GastoMes gt5 = new GastoMes(null,"tenis",10,2018,100,TipoPagamentoEnum.CARTAO_PARCELADO,1,3, tipo3,new Date(),sdf.parse("20/09/2018 10:32"));
		GastoMes gt6 = new GastoMes(null,"tenis",11,2018,100,TipoPagamentoEnum.CARTAO_PARCELADO,2,3, tipo3,new Date(),sdf.parse("20/09/2018 10:32"));
		GastoMes gt7 = new GastoMes(null,"tenis",12,2018,100,TipoPagamentoEnum.CARTAO_PARCELADO,3,3, tipo3,new Date(),sdf.parse("20/09/2018 10:32"));
		
		Cliente c1 = new Cliente(null, "kamila", "andrelsales@gmail.com", "33311083830", pe.encode("111"));
		Cliente c2 = new Cliente(null, "andre","andre.sales@serpro.gov.br", "045347779682",  pe.encode("333"));
		c2.addPerfil(PerfilEnum.ADMIN);	
		
		tipoGastoRepository.saveAll(Arrays.asList(tipo1,tipo2,tipo3,tipo4,tipo5,tipo6,tipo7,tipo8));
		
		gastoMesRepository.saveAll(Arrays.asList(gt1,gt2,gt3,gt4,gt5,gt6,gt7));
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
				
	}

}
