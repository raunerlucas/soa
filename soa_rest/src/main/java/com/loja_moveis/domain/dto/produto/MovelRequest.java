package com.loja_moveis.domain.dto.produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovelRequest {
    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotNull
    private Double preco;

    @NotEmpty
    private String tipoMadeira;

    @NotEmpty
    private String dimensoes;

    private List<Long> fornecedores;
}
