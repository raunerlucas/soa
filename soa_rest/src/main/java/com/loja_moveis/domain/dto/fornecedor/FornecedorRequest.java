package com.loja_moveis.domain.dto.fornecedor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorRequest {
    @NotEmpty
    private String cnpj;

    @NotEmpty
    @Size(max = 255)
    private String nomeFantasia;

    @NotEmpty
    @Size(max = 255)
    private String razaoSocial;
}
