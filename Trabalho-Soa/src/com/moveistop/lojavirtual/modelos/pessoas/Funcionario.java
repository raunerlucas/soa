package com.moveistop.lojavirtual.modelos.pessoas;

import com.moveistop.lojavirtual.modelos.Venda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Funcionario extends Pessoa {

    private String matricula;

    private String cargo;

    public Funcionario(String nome, String telefone, String email, String matricula, String cargo) {
        super(nome, telefone, email);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public Funcionario() {super();}

    public void realizarVenda(Venda venda){
        // TODO: Falta implementar
    }
    public void cancelarVenda(Venda venda){
        // TODO: Falta implementar
    }
    public void emitirNotaFiscal(Venda venda){
        // TODO: Falta implementar
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
