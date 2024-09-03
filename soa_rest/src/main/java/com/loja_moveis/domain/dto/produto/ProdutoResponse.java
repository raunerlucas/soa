package com.loja_moveis.domain.dto.produto;

import com.loja_moveis.domain.entity.Fornecedor;
import com.loja_moveis.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {
    private String nome;

    private String descricao;

    private Double preco;

    private Timestamp dataCriacao;

    private List<Fornecedor> fornecedores;

    public ProdutoResponse(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.dataCriacao = produto.getDataCriacao();
        this.fornecedores = produto.getFornecedores();
    }
}
