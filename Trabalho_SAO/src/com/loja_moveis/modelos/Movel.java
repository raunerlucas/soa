package com.loja_moveis.modelos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Movel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movel extends Produto {

	private String tipoMadeira;

	private String dimensoes;

	public Movel(int codigo, String nome, String descricao, double preco,
				 Date dataCriacao, List<Fornecedor> fornecedor, String tipoMadeira, String dimensoes) {
		super(codigo, nome, descricao, preco, dataCriacao, fornecedor);
		this.tipoMadeira = tipoMadeira;
		this.dimensoes = dimensoes;
	}

	public Movel() {
	}

	@Override
	public String toString() {
		return "Movel{" +
				super.toString()+
				" tipoMadeira='" + tipoMadeira + '\'' +
				", dimensoes='" + dimensoes + '\'' +
				'}';
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