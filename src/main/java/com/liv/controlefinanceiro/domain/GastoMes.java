package com.liv.controlefinanceiro.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liv.controlefinanceiro.domain.enums.TipoPagamentoEnum;

@Entity
public class GastoMes implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String nome;
	private Integer mes;
	private Integer ano;
	private Date instanteCadastro;
//	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date instanteCompra;
	private double valor;
	private Integer tipoPagamento;
	private Integer parcela;
	private Integer totalParecela;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tipogasto_id")
	private TipoGasto tipoGasto;
	
	public GastoMes() {		
	}

	public GastoMes(Integer id, String nome, Integer mes, Integer ano, double valor, TipoPagamentoEnum tipoPagamento, Integer parcela,
			Integer totalParecela, TipoGasto tipoGasto,Date instanteCadastro, Date instanteCompra ) {
		super();
		this.id = id;
		this.nome = nome;
		this.mes = mes;
		this.ano = ano;
		this.valor = valor;
		this.tipoPagamento = tipoPagamento.getCod();
		this.parcela = parcela;
		this.totalParecela = totalParecela;
		this.tipoGasto = tipoGasto;
		this.instanteCadastro = instanteCadastro;
		this.instanteCompra = instanteCompra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoPagamentoEnum getTipoPagamento() {
		return TipoPagamentoEnum.toEnum(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getCod();
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Integer getTotalParecela() {
		return totalParecela;
	}

	public void setTotalParecela(Integer totalParecela) {
		this.totalParecela = totalParecela;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GastoMes other = (GastoMes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInstanteCadastro() {
		return instanteCadastro;
	}

	public void setInstanteCadastro(Date instanteCadastro) {
		this.instanteCadastro = instanteCadastro;
	}

	public Date getInstanteCompra() {
		return instanteCompra;
	}

	public void setInstanteCompra(Date instanteCompra) {
		this.instanteCompra = instanteCompra;
	}
	
	
}
