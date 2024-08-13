package com.moveistop.lojavirtual.daos;

import com.moveistop.lojavirtual.modelos.Fornecedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FornecedorDAO {

    public List<Fornecedor> fornecedors = new ArrayList<>(
            Arrays.asList(
                    new Fornecedor("Fornecedor A", "(11) 1111-2222",
                            "contato@fornecedora.com", "12.345.678/0001-90",
                            "Fornecedor A Ltda."),
                    new Fornecedor("Fornecedor B", "(21) 3333-4444",
                            "vendas@fornecedorb.com", "98.765.432/0001-01",
                            "Fornecedor B Comércio de Produtos"),
                    new Fornecedor("Fornecedor C", "(31) 5555-6666",
                            "suporte@fornecedorc.com", "45.678.901/0001-12",
                            "Distribuidora C S.A."),
                    new Fornecedor("Fornecedor D", "(41) 7777-8888",
                            "pedidos@fornecedord.com", "78.901.234/0001-23",
                            "Importadora e Exportadora D Ltda.")
            ));

    public void addFornecedor(Fornecedor f){
        fornecedors.add(f);
    }
}
