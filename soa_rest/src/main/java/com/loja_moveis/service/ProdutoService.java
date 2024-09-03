package com.loja_moveis.service;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorResponse;
import com.loja_moveis.domain.dto.produto.ProdutoRequest;
import com.loja_moveis.domain.dto.produto.ProdutoResponse;
import com.loja_moveis.domain.entity.Fornecedor;
import com.loja_moveis.domain.entity.Produto;
import com.loja_moveis.exception.FornecedorNotFoundException;
import com.loja_moveis.repository.FornecedorRepository;
import com.loja_moveis.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final FornecedorRepository fornecedorRepository;

    public Page<ProdutoResponse> listar(PaginatedRequest paginatedRequest) {
        PageRequest pageRequest = PageRequest.of(paginatedRequest.getCurrentPage(), paginatedRequest.getQuantityPerPage());
        Page<Produto> produtoPage = produtoRepository.findAll(pageRequest);
        return produtoPage.map(ProdutoResponse::new);
    }

    public Produto cadastrar(ProdutoRequest request) {
        return produtoRepository.save(
                Produto.builder()
                        .nome(request.getNome())
                        .descricao(request.getDescricao())
                        .preco(request.getPreco())
                        .fornecedores(getFornecedores(request.getFornecedores()))
                        .build()
        );
    }

    private List<Fornecedor> getFornecedores(List<Long> fornecedorIds) {
        return fornecedorIds.stream().map(id -> fornecedorRepository.findById(id).orElseThrow(FornecedorNotFoundException::new)).toList();
    }
}
