package com.loja_moveis.modelos;

import com.loja_moveis.adaptadores.AdaptadorDate;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Movel.class })
public class Produto {

    @XmlElement(required = true)
    private int codigo;

    @XmlElement(required = true)
    private String nome;

    private String descricao;
    private double preco;

    @XmlJavaTypeAdapter(AdaptadorDate.class)
    private Date dataCriacao = new Date();

    private Fornecedor fornecedor;

    public Produto(int codigo, String nome, String descricao, double preco,
                   Date dataCriacao,
                   Fornecedor fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataCriacao = dataCriacao;
        this.fornecedor = fornecedor;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return "\tProduto{" +
                "\n\tcodigo=" + codigo +
                "\n\t, nome='" + nome + '\'' +
                "\n\t, descricao='" + descricao + '\'' +
                "\n\t, preco=" + preco +
                "\n\t, dataCriacao=" + dataCriacao +
                "\n\t, fornecedor=" + fornecedor +
                "}\n";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}