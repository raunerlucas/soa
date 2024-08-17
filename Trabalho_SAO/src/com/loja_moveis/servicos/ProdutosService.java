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
import java.util.ArrayList;
import java.util.List;

import static com.loja_moveis.tools.Tools.verificaFornecedor;
import static com.loja_moveis.tools.Tools.verificaUser;


@WebService
public class ProdutosService {

    private final ProdutoDAO produtos;
    private final MovelDAO moveis;
    private final FornecedorDAO fornecedores;

    public ProdutosService() {
        this.produtos = new ProdutoDAO();
        this.moveis = new MovelDAO();
        this.fornecedores = new FornecedorDAO();
    }

    @WebResult(name = "produto")
    public List<? extends Produto> listar() {
        List<Produto> listaP = new ArrayList<>(produtos.listar());
        listaP.addAll(moveis.listar());
        return listaP;
    }

    @WebResult(name = "produtos")
    public List<? extends Produto> listarPaginado(@WebParam(name = "numPag") int numeroDaPagina,
                                                  @WebParam(name = "tamPag") int tamanhoDaPagina) {
        int indiceInicial = numeroDaPagina * tamanhoDaPagina;
        int indiceFinal = indiceInicial + tamanhoDaPagina;

        indiceFinal = Math.min(indiceFinal, listar().size());
        indiceInicial = Math.min(indiceInicial, indiceFinal);

        return listar().subList(indiceInicial, indiceFinal);
    }

    public String criarProtudo(@WebParam(name = "produto") Produto p,
                             @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);

        Fornecedor fornecedor = fornecedores.buscarFornecedorPorCnpj(p.getFornecedor().getCnpj());
        verificaFornecedor(fornecedor);

        p.setFornecedor(fornecedor);
        produtos.criarProduto(p);
        return "Produto criado com sucesso!";
    }

    public String criarMovel(@WebParam(name = "movel") Movel movel,
                           @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);

        Fornecedor fornecedor = fornecedores.buscarFornecedorPorCnpj(movel.getFornecedor().getCnpj());
        verificaFornecedor(fornecedor);

        movel.setFornecedor(fornecedor);
        moveis.criarMovel(movel);
        return "Móvel criado com sucesso!";
    }

    public String excluirProduto(@WebParam(name = "cod") int codigo, @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);
        produtos.removerProduto(codigo);
        return "Produto removido com sucesso!";
    }

    public String excluirMovel(@WebParam(name = "cod") int codigo, @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);
        moveis.removeMovel(codigo);
        return "Móvel removido com sucesso!";
    }


    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/produtos", new ProdutosService());
        System.out.println("Serviço inicializado!");
    }

}
