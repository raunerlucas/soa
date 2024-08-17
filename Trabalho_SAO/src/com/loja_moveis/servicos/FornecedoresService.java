package com.loja_moveis.servicos;

import com.loja_moveis.daos.FornecedorDAO;
import com.loja_moveis.modelos.Fornecedor;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class FornecedoresService {

   public List<Fornecedor> listar() {
      return FornecedorDAO.listarFornecedores();
   }

   public Fornecedor buscar(String cnpj) {
      return FornecedorDAO.buscarFornecedorPorCnpj(cnpj);
   }

    public void cadastrar(String cnpj, String nome, String endereco) {
        Fornecedor fornecedor = new Fornecedor(cnpj, nome, endereco);
        FornecedorDAO.criarFornecedor(fornecedor);
    }

    public void remover(String cnpj) {
        FornecedorDAO.removeFornecedor(cnpj);
    }

   public static void main(String[] args) {
      Endpoint.publish("http://localhost:8080/fornecedores", new FornecedoresService());

   }

}
