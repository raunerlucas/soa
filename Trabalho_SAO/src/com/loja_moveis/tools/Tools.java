package com.loja_moveis.tools;

import com.loja_moveis.modelos.Fornecedor;
import com.loja_moveis.modelos.Usuario;
import com.loja_moveis.servicos.UsuarioNaoAutorizadoException;

import javax.xml.soap.SOAPException;
import java.util.Objects;

public class Tools {

    public static void verificaFornecedor(Fornecedor fornecedor) throws SOAPException {
        if (Objects.isNull(fornecedor))
            throw new SOAPException("Fornecedor não encontrado");
    }

    public static void verificaUser(Usuario usuario) throws UsuarioNaoAutorizadoException {
        if (!usuario.getLogin().equals("soa") && !usuario.getSenha().equals("soa"))
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
    }

    private Tools() {
        throw new IllegalStateException("Utility class");
    }
}
