package com.loja_moveis.daos;

import com.loja_moveis.modelos.Fornecedor;
import com.loja_moveis.modelos.Movel;
import com.loja_moveis.modelos.Produto;

import java.util.*;

public class MovelDAO {

    private static final List<Fornecedor> fornecedor = new FornecedorDAO().listarFornecedores().subList(0,1);

    private static final Date dateCreate = new Date(2024, Calendar.AUGUST,17);

    private final List<Movel> moveis;

    public MovelDAO() {
        this.moveis = new ArrayList<>(Arrays.asList(
                new Movel( 1, "Sofá Confort", "Sofá 3 lugares",
                        1500.00, dateCreate, fornecedor,
                        "Madeira de Pinus", "2m x 1m x 1m"),
                new Movel( 2, "Mesa Jantar", "Mesa para 6 pessoas",
                        800.00, dateCreate, fornecedor,
                        "Madeira de Eucalipto", "2m x 1m"),
                new Movel( 3, "Cama Box", "Cama Box Casal", 1200.00, dateCreate, fornecedor,
                        "Madeira de Pinus", "2m x 1,5m")));

    }

    public List<Movel> listar() {
        return moveis;
    }

    public List<Produto> buscarProdutoPorNome(String nome) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto p : moveis) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public void criarMovel(Movel movel) {
        moveis.add(movel);
    }

    public void removeMovel(int id) {
        moveis.removeIf(movel -> movel.getCodigo() == id);
    }
}