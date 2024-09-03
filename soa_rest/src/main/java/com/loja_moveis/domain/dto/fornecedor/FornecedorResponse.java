package com.loja_moveis.domain.dto.fornecedor;

import com.loja_moveis.domain.entity.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorResponse {
    private String cnpj;
    private String nomeFantasia;

    public FornecedorResponse(Fornecedor fornecedor) {
        this.cnpj = fornecedor.getCnpj();
        this.nomeFantasia = fornecedor.getNomeFantasia();
    }
}
