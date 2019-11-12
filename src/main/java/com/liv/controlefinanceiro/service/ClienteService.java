package com.liv.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.liv.controlefinanceiro.domain.Cliente;
import com.liv.controlefinanceiro.repository.ClienteRepository;
import com.liv.controlefinanceiro.service.exceptions.CfDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;

	public List<Cliente> searchAll() {
		return clienteRepository.findAll();
	}

	public Cliente search(Integer id) throws CfObjectNotFoundException {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new CfObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente tipo) {

		tipo.setId(null);
		tipo = clienteRepository.save(tipo);
//		emailService.envioCadastroCliente(tipo);
//		emailService.envioCadastroClienteHtmlEmail(tipo);
		return tipo;
		
	}

	public Cliente update(Cliente tipo) throws CfObjectNotFoundException {

		search(tipo.getId());
		return clienteRepository.save(tipo);
	}

	public void delete(Integer id) throws CfObjectNotFoundException, CfDataIntegrityException {
		search(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new CfDataIntegrityException("Não é possivel excluir um tipo de gasto que já foi usado");
		}

	}

	public Page<Cliente> findPage(Integer pagina, Integer linhasPorPagina, String ordernarPor, String direcao) {
		PageRequest page = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernarPor);
		return clienteRepository.findAll(page);

	}

}
