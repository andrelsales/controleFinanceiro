package com.liv.controlefinanceiro.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.service.TipoGastoService;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;

@RestController
@RequestMapping(value = "/tipogasto")
public class TipoGastoResource {
	
	@Autowired
	TipoGastoService  tipoGastoService;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws CfObjectNotFoundException {
		
		TipoGasto tipoGasto = tipoGastoService.search(id);			
		return ResponseEntity.ok().body(tipoGasto);
		
	}

}
