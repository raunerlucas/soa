package com.moveistop.lojavirtual.daos;

import com.moveistop.lojavirtual.modelos.pessoas.Funcionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncionarioDAO {

    public List<Funcionario> funcionarios = new ArrayList<>(
            Arrays.asList(
                    new Funcionario("Ana Maria", "(11) 98765-4321",
                            "ana.maria@lojavirtual.com","12345", "Gerente"),
                    new Funcionario("Carlos Santos", "(21) 91234-5678",
                            "carlos.santos@lojavirtual.com", "67890", "Vendedor"),
                    new Funcionario("Fernanda Lima", "(31) 94321-0987",
                            "fernanda.lima@lojavirtual.com", "24680", "Vendedor"),
                    new Funcionario("João Pereira", "(41) 95678-1234",
                            "joao.pereira@lojavirtual.com", "13579", "Vendedor")
            ));

    public void addFuncionario(Funcionario fun) {
        funcionarios.add(fun);
    }
}
