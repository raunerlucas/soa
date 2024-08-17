package com.loja_moveis.servicos;

import com.loja_moveis.daos.FornecedorDAO;
import com.loja_moveis.modelos.Fornecedor;
import com.loja_moveis.modelos.Usuario;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class FornecedoresService {

    @WebResult(name = "fornecedor")
    public List<Fornecedor> listar() {
        return FornecedorDAO.listarFornecedores();
    }

    @WebResult(name = "fornecedor")
    public List<Fornecedor> listarPaginado(int numeroDaPagina, int tamanhoDaPagina) {
        return FornecedorDAO.listarFornecedores().subList(
                numeroDaPagina * tamanhoDaPagina,
                Math.min((numeroDaPagina + 1) * tamanhoDaPagina, FornecedorDAO.listarFornecedores().size()));
    }

    @WebResult(name = "fornecedor")
    public Fornecedor buscar(String cnpj) {
        return FornecedorDAO.buscarFornecedorPorCnpj(cnpj);
    }

    @WebResult(name = "fornecedor")
    public void cadastrar(String cnpj, String nome, String endereco,
                          @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        Fornecedor fornecedor = new Fornecedor(cnpj, nome, endereco);
        if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa"))
            FornecedorDAO.criarFornecedor(fornecedor);
    }

    public void remover(String cnpj) {
        FornecedorDAO.removeFornecedor(cnpj);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/fornecedores", new FornecedoresService());

    }

}
