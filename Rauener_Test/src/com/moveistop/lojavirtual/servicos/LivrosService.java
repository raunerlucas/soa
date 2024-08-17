package com.moveistop.lojavirtual.servicos;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Endpoint;

import com.moveistop.lojavirtual.modelos.Livro;
import com.moveistop.lojavirtual.modelos.Usuario;

@WebService
public class LivrosService {

	private LivroDAO livroDAO = new LivroDAO();

	@WebResult(name = "livro")
	public List<Livro> listarLivros() {
		return livroDAO.listarLivros();
	}

	@WebResult(name = "livro")
	public List<Livro> listarLivrosPaginacao(int numeroDaPagina, int tamanhoDaPagina) {
		return livroDAO.listarLivros(numeroDaPagina, tamanhoDaPagina);
	}

	public void criarLivro(@WebParam(name = "livro") Livro livro,
						   @WebParam(name = "usuario", header = true) Usuario usuario)
			throws UsuarioNaoAutorizadoException, SOAPException {
		if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
			livroDAO.criarLivro(livro);
		} else {
			throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
		}
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/livros", new LivrosService());
		System.out.println("Serviço inicializado!");

	}

}
