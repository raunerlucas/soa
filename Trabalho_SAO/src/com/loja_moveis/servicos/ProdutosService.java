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
import java.util.Objects;

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
        if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
            Fornecedor fornecedor = FornecedorDAO.buscarFornecedorPorCnpj(cnpjFornecedor);
            if (Objects.isNull(fornecedor))
                throw new SOAPException("Fornecedor não encontrado");
            Produto produto = new Produto(codigo, nome, descricao, preco, dataCriacao, fornecedor);
            ProdutoDAO.criarProduto(produto);
        } else
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
    }


    public void criarMovel(int codigo, String nome, String descricao,
                           double preco, Date dataCriacao, String cnpjFornecedor,
                           String material, String dimensoes,
                           @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
            Fornecedor fornecedor = FornecedorDAO.buscarFornecedorPorCnpj(cnpjFornecedor);
            if (Objects.isNull(fornecedor))
                throw new SOAPException("Fornecedor não encontrado");
            Movel movel = new Movel(codigo, nome, descricao, preco, dataCriacao,
                    fornecedor, material, dimensoes);
            MovelDAO.criarMovel(movel);
        } else
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
    }

    public void excluirProduto(int codigo, @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
            ProdutoDAO.removerProduto(codigo);
        } else
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
    }

    public void excluirMovel(int codigo, @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
            MovelDAO.removeMovel(codigo);
        } else
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/produtos", new ProdutosService());
        System.out.println("Serviço inicializado!");
    }

}
