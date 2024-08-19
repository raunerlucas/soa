package com.loja_moveis.daos;

import com.loja_moveis.modelos.Fornecedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FornecedorDAO {

    private final List<Fornecedor> fornecedor;

    public FornecedorDAO() {
        fornecedor =
                new ArrayList<>(Arrays.asList(
                        new Fornecedor("123", "Forn Sofás", "Indústria de Sofás"),
                        new Fornecedor("456", "Só o Ouro", "Indústria de moveis")
                ));
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedor;
    }

    public List<Fornecedor> buscarFornecedorPorCnpj(List<Fornecedor> fornecedores) {
        return fornecedor.stream()
                .filter(f -> fornecedores.stream()
                        .anyMatch(f2 -> f.getCnpj().equals(f2.getCnpj())))
                .collect(Collectors.toList());
    }
    public Fornecedor buscarFornecedorPorCnpj(String cnpj) {
        for (Fornecedor f : fornecedor) {
            if (f.getCnpj().equals(cnpj)) {
                return f;
            }
        }
        return null;
    }

    public void criarFornecedor(Fornecedor movel) {
        fornecedor.add(movel);
    }

    public void removeFornecedor(String cnpj) {
        fornecedor.removeIf(f -> f.getCnpj().equals(cnpj));
    }
}