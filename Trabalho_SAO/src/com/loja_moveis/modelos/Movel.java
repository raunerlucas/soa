package com.loja_moveis.modelos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movel extends Produto {

	private String tipoMadeira;

	private String dimensoes;

	public Movel(int codigo, String nome, String descricao, double preco,
				 Date dataCriacao, Fornecedor fornecedor, String tipoMadeira, String dimensoes) {
		super(codigo, nome, descricao, preco, dataCriacao, fornecedor);
		this.tipoMadeira = tipoMadeira;
		this.dimensoes = dimensoes;
	}

	public Movel() {
	}

	public String getTipoMadeira() {
		return tipoMadeira;
	}

	public void setTipoMadeira(String tipoMadeira) {
		this.tipoMadeira = tipoMadeira;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}
}