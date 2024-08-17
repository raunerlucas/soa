package com.loja_moveis.daos;

import com.loja_moveis.modelos.Fornecedor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FornecedorDAO {

    private static final List<Fornecedor> fornecedor =
            new ArrayList<>(Collections.singletonList(new Fornecedor("123", "Forn Sofás", "Indústria de Sofás")));

    public static List<Fornecedor> listarFornecedores() {
        return fornecedor;
    }

    public static Fornecedor buscarFornecedorPorCnpj(String cnpj) {
        for (Fornecedor f : fornecedor) {
            if (f.getCnpj().equals(cnpj)) {
                return f;
            }
        }
        return null;
    }

    public static void criarFornecedor(Fornecedor movel) {
        fornecedor.add(movel);
    }

    public static void removeFornecedor(String cnpj) {
        fornecedor.removeIf(f -> f.getCnpj().equals(cnpj));
    }
}