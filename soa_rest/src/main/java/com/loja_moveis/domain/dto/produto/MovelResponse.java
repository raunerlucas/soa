package com.loja_moveis.domain.dto.produto;

import com.loja_moveis.domain.entity.Fornecedor;
import com.loja_moveis.domain.entity.Movel;
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
public class MovelResponse {
    private String nome;

    private String descricao;

    private Double preco;

    private Timestamp dataCriacao;

    private String tipoMadeira;

    private String dimensoes;

    private List<Fornecedor> fornecedores;

    public MovelResponse(Movel movel) {
        this.nome = movel.getNome();
        this.descricao = movel.getDescricao();
        this.preco = movel.getPreco();
        this.dataCriacao = movel.getDataCriacao();
        this.fornecedores = movel.getFornecedores();
        this.tipoMadeira = movel.getTipoMadeira();
        this.dimensoes = movel.getDimensoes();
    }
}
