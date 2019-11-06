package com.liv.controlefinanceiro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.repository.TipoGastoRepository;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;


@Service
public class TipoGastoService {

	@Autowired
	TipoGastoRepository tipoGastoRepository;

	public TipoGasto search(Integer id) throws CfObjectNotFoundException {
		Optional<TipoGasto> obj =  tipoGastoRepository.findById(id);
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


}

