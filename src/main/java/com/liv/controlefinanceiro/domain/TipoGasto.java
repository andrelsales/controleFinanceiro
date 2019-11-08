package com.liv.controlefinanceiro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.websocket.ClientEndpoint;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.liv.controlefinanceiro.service.validation.TipoGastoInsert;

@Entity
@TipoGastoInsert
public class TipoGasto implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="preenchimento obrigatório")
	@Length(min=3 , max=40, message="tamanho minimo 3, máximo 40")
	private String nome;
	private Boolean obrigatorio;
	
	@JsonIgnore	
	@OneToMany(mappedBy="tipoGasto")
	private List<GastoMes> gastosmes = new ArrayList<GastoMes>();
	
	
	public TipoGasto() {
		
	}

	public TipoGasto(Integer id, String nome, Boolean obrigatorio) {
		super();
		this.id = id;
		this.nome = nome;
		this.obrigatorio = obrigatorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(Boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public List<GastoMes> getGastosmes() {
		return gastosmes;
	}

	public void setGastosmes(List<GastoMes> gastosmes) {
		this.gastosmes = gastosmes;
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
		TipoGasto other = (TipoGasto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoGasto [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", obrigatorio=");
		builder.append(obrigatorio);
		builder.append(", gastosmes=");
		builder.append(gastosmes);
		builder.append("]");
		return builder.toString();
	}


	
}
