package com.liv.controlefinanceiro.domain.enums;

public enum TipoPagamentoEnum {
	
	DINHEIRO(1,"Dinheiro"),
	DEBITO(2,"Debito"),
	CARTAO_VISTA(3,"Cartao Vista"),
	CARTAO_PARCELADO(4,"cartao parcelado");

	private int cod;
	private String descricao;
	
	private TipoPagamentoEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoPagamentoEnum toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoPagamentoEnum x : TipoPagamentoEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}


}
