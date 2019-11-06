package com.liv.controlefinanceiro.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tiposgastos")
public class TipoGastoResource {

	@RequestMapping(method = RequestMethod.GET)
	public String teste() {
		return "OK";
	}

}
