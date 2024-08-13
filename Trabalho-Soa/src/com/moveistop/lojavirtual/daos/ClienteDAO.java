package com.moveistop.lojavirtual.daos;

import com.moveistop.lojavirtual.modelos.pessoas.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteDAO {

    public static List<Cliente> clientes = new ArrayList<>(
            Arrays.asList(
                    new Cliente("João Silva", "(11) 99999-8888",
                            "joao.silva@email.com", "123.456.789-00",
                            "Rua A, 123, São Paulo - SP"),
                    new Cliente("Maria Oliveira", "(21) 3333-4444",
                            "maria.oliveira@email.com", "987.654.321-11",
                            "Av. B, 456, Rio de Janeiro - RJ"),
                    new Cliente("Pedro Souza", "(31) 5555-6666",
                            "pedro.souza@email.com", "741.852.963-22",
                            "Rua C, 789, Belo Horizonte - MG"),
                    new Cliente("Ana Santos", "(41) 7777-8888",
                            "ana.santos@email.com", "369.258.147-33",
                            "Rua D, 987, Curitiba - PR")));

    public void addClient(Cliente c) throws Exception {
        clientes.add(c);
    }
}
