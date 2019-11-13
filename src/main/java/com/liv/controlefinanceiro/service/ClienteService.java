package com.liv.controlefinanceiro.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.liv.controlefinanceiro.domain.Cliente;
import com.liv.controlefinanceiro.domain.enums.PerfilEnum;
import com.liv.controlefinanceiro.repository.ClienteRepository;
import com.liv.controlefinanceiro.security.UserSS;
import com.liv.controlefinanceiro.service.exceptions.CFAuthorizationException;
import com.liv.controlefinanceiro.service.exceptions.CFDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CFObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private S3Service s3Service;

	public List<Cliente> searchAll() {
		return clienteRepository.findAll();
	}

	public Cliente search(Integer id) throws CFObjectNotFoundException {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new CFObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente tipo) {

		tipo.setId(null);
		tipo = clienteRepository.save(tipo);
//		emailService.envioCadastroCliente(tipo);
//		emailService.envioCadastroClienteHtmlEmail(tipo);
		return tipo;
		
	}
	
	public Cliente find(Integer id) throws CFObjectNotFoundException {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(PerfilEnum.ADMIN) && !id.equals(user.getId())) {
			throw new CFAuthorizationException("Acesso negado");
		}
		
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new CFObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
}

	public Cliente update(Cliente tipo) throws CFObjectNotFoundException {

		search(tipo.getId());
		return clienteRepository.save(tipo);
	}

	public void delete(Integer id) throws CFObjectNotFoundException, CFDataIntegrityException {
		search(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new CFDataIntegrityException("Não é possivel excluir um tipo de gasto que já foi usado");
		}

	}

	public Page<Cliente> findPage(Integer pagina, Integer linhasPorPagina, String ordernarPor, String direcao) {
		PageRequest page = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernarPor);
		return clienteRepository.findAll(page);

	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile)
	{
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new CFAuthorizationException("Acesso negado");
		}
		URI uri =  s3Service.uploadFile(multipartFile);
		
		Optional<Cliente> cli = clienteRepository.findById(user.getId());
		cli.get().setImageURL(uri.toString());
		clienteRepository.save(cli.get());		
		return uri;
		
	}

}
