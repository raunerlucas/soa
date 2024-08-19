package com.loja_moveis.daos;

import com.loja_moveis.modelos.Produto;

import java.util.*;

public class ProdutoDAO {

    private final List<Produto> produtos;

    public ProdutoDAO() {
        this.produtos = new ArrayList<>(
                Collections.singletonList(
                        new Produto(1, "Cadeira", "Para mesa de jantar", 100.0
                                , new Date(2024, Calendar.AUGUST, 17), new FornecedorDAO().listarFornecedores())));
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        List<Produto> lista = listar();
        return lista.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }

    public void criarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int codigo) {
        produtos.removeIf(produto -> produto.getCodigo() == codigo);
    }
}
