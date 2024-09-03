package com.loja_moveis.domain.dto.produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotNull
    private Double preco;

    private List<Long> fornecedores;
}
