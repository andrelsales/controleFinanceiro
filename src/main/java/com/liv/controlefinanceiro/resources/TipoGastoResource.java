package com.liv.controlefinanceiro.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liv.controlefinanceiro.domain.TipoGasto;

@RestController
@RequestMapping(value = "/tiposgastos")
public class TipoGastoResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<TipoGasto> teste() {
		
		TipoGasto tipo1 = new TipoGasto(1,"finaciamento",true);
		TipoGasto tipo2 = new TipoGasto(1,"escola",true);
		TipoGasto tipo3 = new TipoGasto(1,"festa",false);
		
		List<TipoGasto> listaTipoGasto = new ArrayList<TipoGasto>();
		listaTipoGasto.add(tipo1);
		listaTipoGasto.add(tipo2);
		listaTipoGasto.add(tipo3);
		return listaTipoGasto;
	}

}
