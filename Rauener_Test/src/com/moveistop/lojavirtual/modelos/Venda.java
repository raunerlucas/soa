package com.moveistop.lojavirtual.modelos;

import com.moveistop.lojavirtual.adaptadores.AdaptadorDate;
import com.moveistop.lojavirtual.modelos.pessoas.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {
    private String codigo;

    @XmlJavaTypeAdapter(AdaptadorDate.class)
    private Date data = new Date();

    private Cliente cliente;
    private Funcionario funcionario;

    @XmlElementWrapper(name = "itens")
    @XmlElement(name = "item")
    private List<ItemVenda> itens;

    public Venda(String codigo, Cliente cliente, Funcionario funcionario, List<ItemVenda> itens) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.itens = itens;
    }

    public Venda() {}

    public double ValorTotal() {
        return itens.stream().mapToDouble(ItemVenda::calcularSubtotal).sum();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
