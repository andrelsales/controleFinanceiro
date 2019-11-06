package com.liv.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liv.controlefinanceiro.domain.GastoMes;

@Repository
public interface GastoMesRepository  extends JpaRepository<GastoMes, Integer> {

}
