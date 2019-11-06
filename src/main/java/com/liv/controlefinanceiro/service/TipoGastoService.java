package com.liv.controlefinanceiro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liv.controlefinanceiro.domain.TipoGasto;
import com.liv.controlefinanceiro.repository.TipoGastoRepository;

@Service
public class TipoGastoService {

	@Autowired
	TipoGastoRepository tipoGastoRepository;

	public TipoGasto search(Integer id) {
		Optional<TipoGasto> obj =  tipoGastoRepository.findById(id);
		return obj.orElse(null);
	}

}
