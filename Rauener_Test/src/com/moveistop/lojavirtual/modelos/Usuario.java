package com.moveistop.lojavirtual.modelos;

import com.moveistop.lojavirtual.modelos.pessoas.Pessoa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Pessoa.class})
public class Usuario {

    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {}

    public String getLogin() {
        if (login != null)
            return login;
        return "";
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        if (senha != null)
            return senha;
        return "";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
