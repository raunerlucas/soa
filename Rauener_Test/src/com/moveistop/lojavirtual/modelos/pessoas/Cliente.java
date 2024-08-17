package com.moveistop.lojavirtual.modelos.pessoas;

import com.moveistop.lojavirtual.modelos.Venda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente extends Pessoa {
    private String cpf;
    private String endereco;

    public Cliente(String nome, String telefone, String email, String cpf, String endereco) {
        super(nome, telefone, email);
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente() {super();}

    public void realizarCompra(Venda venda){
        // TODO: Falta implementar
    }
    public void cancelarCompra(Venda venda){
        // TODO: Falta implementar
    }

}
