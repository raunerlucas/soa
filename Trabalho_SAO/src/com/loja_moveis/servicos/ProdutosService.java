package com.loja_moveis.servicos;

import com.loja_moveis.daos.FornecedorDAO;
import com.loja_moveis.daos.MovelDAO;
import com.loja_moveis.daos.ProdutoDAO;
import com.loja_moveis.modelos.Fornecedor;
import com.loja_moveis.modelos.Movel;
import com.loja_moveis.modelos.Produto;
import com.loja_moveis.modelos.Usuario;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Endpoint;
import java.util.Date;
import java.util.List;

import static com.loja_moveis.tools.Tools.verificaFornecedor;
import static com.loja_moveis.tools.Tools.verificaUser;


@WebService
public class ProdutosService {

    private final List<? extends Produto> produtos = ProdutoDAO.listar();

    @WebResult(name = "produtos")
    public List<? extends Produto> listar() {
        return produtos;
    }

    @WebResult(name = "produtos")
    public List<? extends Produto> listarPaginado(int numeroDaPagina, int tamanhoDaPagina) {
        return produtos.subList(
                numeroDaPagina * tamanhoDaPagina,
                Math.min((numeroDaPagina + 1) * tamanhoDaPagina, produtos.size()));
    }


    public void criarProtudo(int codigo, String nome, String descricao,
                             double preco, Date dataCriacao, String cnpjFornecedor,
                             @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
            verificaUser(usuario);

            Fornecedor fornecedor = FornecedorDAO.buscarFornecedorPorCnpj(cnpjFornecedor);
            verificaFornecedor(fornecedor);

            Produto produto = new Produto(codigo, nome, descricao, preco, dataCriacao, fornecedor);
            ProdutoDAO.criarProduto(produto);
    }


    public void criarMovel(int codigo, String nome, String descricao,
                           double preco, Date dataCriacao, String cnpjFornecedor,
                           String material, String dimensoes,
                           @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);

        Fornecedor fornecedor = FornecedorDAO.buscarFornecedorPorCnpj(cnpjFornecedor);
        verificaFornecedor(fornecedor);

        Movel movel = new Movel(codigo, nome, descricao, preco, dataCriacao,
                fornecedor, material, dimensoes);
        MovelDAO.criarMovel(movel);
    }

    public void excluirProduto(int codigo, @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);
        ProdutoDAO.removerProduto(codigo);
    }

    public void excluirMovel(int codigo, @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);
        MovelDAO.removeMovel(codigo);
    }



    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/produtos", new ProdutosService());
        System.out.println("Serviço inicializado!");
    }

}
