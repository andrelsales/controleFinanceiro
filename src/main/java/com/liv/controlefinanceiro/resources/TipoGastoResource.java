package com.liv.controlefinanceiro.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.service.TipoGastoService;
import com.liv.controlefinanceiro.service.exceptions.CFDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CFObjectNotFoundException;

@RestController
@RequestMapping(value = "/tipogasto")
public class TipoGastoResource {

	@Autowired
	TipoGastoService tipoGastoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipoGasto> find(@PathVariable Integer id) throws CFObjectNotFoundException {

		TipoGasto tipoGasto = tipoGastoService.search(id);
		return ResponseEntity.ok().body(tipoGasto);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TipoGasto tipo) {
		TipoGasto obj = tipoGastoService.insert(tipo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TipoGasto tipo, @PathVariable Integer id)
			throws CFObjectNotFoundException {

		tipo = tipoGastoService.update(tipo);
		return ResponseEntity.noContent().build();

	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws CFObjectNotFoundException, CFDataIntegrityException {

		tipoGastoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<TipoGasto>> findAll() throws CFObjectNotFoundException {

		List<TipoGasto> listaTipoGasto = tipoGastoService.searchAll();
		return ResponseEntity.ok().body(listaTipoGasto);
	}
	
	@RequestMapping(value= "/page" ,method = RequestMethod.GET)
	public ResponseEntity<Page<TipoGasto>> findPage(
			@RequestParam(value="pagina" , defaultValue="0") Integer pagina, 
			@RequestParam(value="linhasPorPagina" , defaultValue="24") Integer linhasPorPagina, 
			@RequestParam(value="ordernarPor" , defaultValue="nome") String ordernarPor, 
			@RequestParam(value="direcao" , defaultValue="ASC") String direcao) throws CFObjectNotFoundException {

		Page<TipoGasto> listaTipoGasto = tipoGastoService.findPage(pagina, linhasPorPagina, ordernarPor, direcao);
		return ResponseEntity.ok().body(listaTipoGasto);
	}
	
	

}
