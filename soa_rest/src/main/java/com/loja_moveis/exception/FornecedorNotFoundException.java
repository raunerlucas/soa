package com.loja_moveis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FornecedorNotFoundException extends RuntimeException {
    public FornecedorNotFoundException() {
        super("Fornecedor não encontrado!");
    }
}
