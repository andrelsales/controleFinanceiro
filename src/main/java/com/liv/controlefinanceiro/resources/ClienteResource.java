package com.liv.controlefinanceiro.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.liv.controlefinanceiro.domain.Cliente;
import com.liv.controlefinanceiro.service.ClienteService;
import com.liv.controlefinanceiro.service.exceptions.CFDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CFObjectNotFoundException;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) throws CFObjectNotFoundException {

		Cliente cliente = clienteService.find(id);
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente tipo) {
		Cliente obj = clienteService.insert(tipo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Cliente tipo, @PathVariable Integer id)
			throws CFObjectNotFoundException {

		tipo = clienteService.update(tipo);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws CFObjectNotFoundException, CFDataIntegrityException {

		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() throws CFObjectNotFoundException {

		List<Cliente> listaCliente = clienteService.searchAll();
		return ResponseEntity.ok().body(listaCliente);
	}
	
	@RequestMapping(value= "/page" ,method = RequestMethod.GET)
	public ResponseEntity<Page<Cliente>> findPage(
			@RequestParam(value="pagina" , defaultValue="0") Integer pagina, 
			@RequestParam(value="linhasPorPagina" , defaultValue="24") Integer linhasPorPagina, 
			@RequestParam(value="ordernarPor" , defaultValue="nome") String ordernarPor, 
			@RequestParam(value="direcao" , defaultValue="ASC") String direcao) throws CFObjectNotFoundException {

		Page<Cliente> listaCliente = clienteService.findPage(pagina, linhasPorPagina, ordernarPor, direcao);
		return ResponseEntity.ok().body(listaCliente);
	}
	
	

}
