package com.loja_moveis.daos;

import com.loja_moveis.modelos.Produto;

import java.util.*;

public class ProdutoDAO {

    private static final List<Produto> produtos = new ArrayList<>(
            Collections.singletonList(
                    new Produto(1, "Cadeira", "Para mesa de jantar", 100.0
                            , new Date(2024, Calendar.AUGUST, 17), FornecedorDAO.listarFornecedores().get(0))));

    public static List<Produto> listar() {
        List<Produto> lista = new ArrayList<>(produtos);
        lista.addAll(MovelDAO.listarMoveis());
        return lista;
    }

    public static Produto buscarProdutoPorCodigo(int codigo) {
        List<Produto> lista = listar();
        return lista.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }

    public static void criarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static void removerProduto(int codigo) {
        produtos.removeIf(produto -> produto.getCodigo() == codigo);
    }
}
