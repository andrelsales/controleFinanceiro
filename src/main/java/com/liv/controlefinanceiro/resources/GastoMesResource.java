package com.liv.controlefinanceiro.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liv.controlefinanceiro.domain.GastoMes;
import com.liv.controlefinanceiro.service.GastoMesService;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;

@RestController
@RequestMapping(value = "/gastomes")
public class GastoMesResource {
	
	@Autowired
	GastoMesService  gastoMesService;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<GastoMes> find(@PathVariable Integer id) throws CfObjectNotFoundException {
		
		GastoMes tipoGasto = gastoMesService.search(id);			
		return ResponseEntity.ok().body(tipoGasto);

	}

}
