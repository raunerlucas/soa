package com.moveistop.lojavirtual.modelos.pessoas;

import com.moveistop.lojavirtual.modelos.Fornecedor;
import com.moveistop.lojavirtual.modelos.Usuario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Funcionario.class, Cliente.class, Fornecedor.class })
public class Pessoa extends Usuario {

    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email) {
        super(email,"123");
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa() {}

    public void atualizarInformacoes(String newNome, String newTelefone,String newEmail) {
           setNome(newNome != null && !newNome.isEmpty() ? newNome : nome);
           setTelefone(newTelefone != null && !newTelefone.isEmpty() ? newTelefone : telefone);
           setEmail(newEmail != null && !newEmail.isEmpty() ? newEmail : email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}