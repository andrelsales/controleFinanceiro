package com.liv.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.repository.TipoGastoRepository;
import com.liv.controlefinanceiro.service.exceptions.CfDataIntegrityException;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;

@Service
public class TipoGastoService {

	@Autowired
	TipoGastoRepository tipoGastoRepository;

	public List<TipoGasto> searchAll() {
		return tipoGastoRepository.findAll();
	}

	public TipoGasto search(Integer id) throws CfObjectNotFoundException {
		Optional<TipoGasto> obj = tipoGastoRepository.findById(id);
		return obj.orElseThrow(() -> new CfObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoGasto.class.getName()));
	}

	public TipoGasto insert(TipoGasto tipo) {

		tipo.setId(null);
		return tipoGastoRepository.save(tipo);
	}

	public TipoGasto update(TipoGasto tipo) throws CfObjectNotFoundException {

		search(tipo.getId());
		return tipoGastoRepository.save(tipo);
	}

	public void delete(Integer id) throws CfObjectNotFoundException, CfDataIntegrityException {
		search(id);
		try {
			tipoGastoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new CfDataIntegrityException("Não é possivel excluir um tipo de gasto que já foi usado");
		}

	}

	public Page<TipoGasto> findPage(Integer pagina, Integer linhasPorPagina, String ordernarPor, String direcao) {
		PageRequest page = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordernarPor);
		return tipoGastoRepository.findAll(page);

	}

}
