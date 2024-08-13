package com.moveistop.lojavirtual.servicos;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.moveistop.lojavirtual.modelos.Autor;

@WebService
public class AutoresService {

   public List<Autor> listarAutores() {
      return AutorDAO.getAutors();
   }

   public static void main(String[] args) {
      Endpoint.publish("http://localhost:8080/autores", new AutoresService());

   }

}
