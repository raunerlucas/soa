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

import static com.loja_moveis.tools.Tools.verificaFornecedor;
import static com.loja_moveis.tools.Tools.verificaUser;

@WebService
public class FornecedoresService {

    private final FornecedorDAO fornecedores;

    public FornecedoresService() {
        fornecedores = new FornecedorDAO();
    }

    @WebResult(name = "fornecedor")
    public List<Fornecedor> listar() {
        return fornecedores.listarFornecedores();
    }

    @WebResult(name = "fornecedor")
    public List<Fornecedor> listarPaginado(@WebParam(name = "numPag") int numeroDaPagina,
                                           @WebParam(name = "tamPag") int tamanhoDaPagina) {
        return fornecedores.listarFornecedores().subList(
                numeroDaPagina * tamanhoDaPagina,
                Math.min((numeroDaPagina + 1) * tamanhoDaPagina, fornecedores.listarFornecedores().size()));
    }

    @WebResult(name = "fornecedor")
    public Fornecedor buscar(@WebParam(name = "cnpj") String cnpj) throws SOAPException {
        Fornecedor fornecedor = fornecedores.buscarFornecedorPorCnpj(cnpj);
        verificaFornecedor(fornecedor);
        return fornecedor;
    }

    public String cadastrar(@WebParam(name = "fornecedor") Fornecedor fornecedor,
                          @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {
        verificaUser(usuario);
        fornecedores.criarFornecedor(fornecedor);
        return "Fornecedor cadastrado com sucesso!";
    }

    public String remover(@WebParam(name = "cnpj") String cnpj) {
        fornecedores.removeFornecedor(cnpj);
        return "Fornecedor removido com sucesso!";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/fornecedores", new FornecedoresService());
        System.out.println("Serviço inicializado!");
    }

}
