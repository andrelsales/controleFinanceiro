package com.liv.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liv.controlefinanceiro.domain.TipoGasto;

@Repository
public interface TipoGastoRepository  extends JpaRepository<TipoGasto, Integer> {

}
