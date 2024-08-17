package com.moveistop.lojavirtual.modelos;

import com.moveistop.lojavirtual.modelos.pessoas.Pessoa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Fornecedor extends Pessoa {
    private String cnpj;
    private String razaoSocial;

    public Fornecedor(String nome, String telefone, String email, String cnpj, String razaoSocial) {
        super(nome, telefone, email);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public Fornecedor() {super();}

    public void cadastrarProduto(Produto Produto){
        // TODO: Falta implementar
    }
    public void atualizarEstoque(Produto Produto, int quantidade){
        // TODO: Falta implementar
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
