package com.liv.controlefinanceiro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liv.controlefinanceiro.domain.GastoMes;
import com.liv.controlefinanceiro.repository.GastoMesRepository;
import com.liv.controlefinanceiro.service.exceptions.CfObjectNotFoundException;


@Service
public class GastoMesService {

	@Autowired
	GastoMesRepository GastoMesRepository;

	public GastoMes search(Integer id) throws CfObjectNotFoundException {
		Optional<GastoMes> obj =  GastoMesRepository.findById(id);
		return obj.orElseThrow(() -> new CfObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + GastoMes.class.getName()));
	}
}

