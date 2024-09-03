package com.loja_moveis.service;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorResponse;
import com.loja_moveis.domain.entity.Fornecedor;
import com.loja_moveis.domain.entity.Produto;
import com.loja_moveis.exception.FornecedorNotFoundException;
import com.loja_moveis.repository.FornecedorRepository;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    private final FornecedorRepository repository;
    public Page<FornecedorResponse> listar(PaginatedRequest paginatedRequest) {
        PageRequest pageRequest = PageRequest.of(paginatedRequest.getCurrentPage(), paginatedRequest.getQuantityPerPage());
        Page<Fornecedor> fornecedorPage = repository.findAll(pageRequest);
        return fornecedorPage.map(FornecedorResponse::new);
    }

    public Fornecedor getById(Long id) {
        return repository.findById(id).orElseThrow(FornecedorNotFoundException::new);
    }

    public void deleteById(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(FornecedorNotFoundException::new);
        fornecedor.setAtivo(false);
        repository.save(fornecedor);
    }

    public Fornecedor cadastrar(FornecedorRequest request) {
        return repository.save(
                Fornecedor.builder()
                        .cnpj(request.getCnpj())
                        .nomeFantasia(request.getNomeFantasia())
                        .razaoSocial(request.getRazaoSocial())
                        .ativo(true)
                        .build()
        );
    }

    public Fornecedor update(FornecedorRequest request, Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(FornecedorNotFoundException::new);
        fornecedor.setCnpj(request.getCnpj());
        fornecedor.setNomeFantasia(request.getNomeFantasia());
        fornecedor.setRazaoSocial(request.getRazaoSocial());
        return repository.save(fornecedor);
    }

    public List<Produto> getProdutos(Long id) {
        Fornecedor fornecedor = getById(id);
        return fornecedor.getProdutos();
    }
}
