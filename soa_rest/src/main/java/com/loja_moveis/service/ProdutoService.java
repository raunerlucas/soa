package com.loja_moveis.service;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.produto.MovelRequest;
import com.loja_moveis.domain.dto.produto.MovelResponse;
import com.loja_moveis.domain.dto.produto.ProdutoRequest;
import com.loja_moveis.domain.dto.produto.ProdutoResponse;
import com.loja_moveis.domain.entity.Fornecedor;
import com.loja_moveis.domain.entity.Movel;
import com.loja_moveis.domain.entity.Produto;
import com.loja_moveis.exception.FornecedorNotFoundException;
import com.loja_moveis.exception.ProdutoNotFoundException;
import com.loja_moveis.repository.FornecedorRepository;
import com.loja_moveis.repository.MovelRepository;
import com.loja_moveis.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final MovelRepository movelRepository;
    private final FornecedorRepository fornecedorRepository;

    public Page<ProdutoResponse> listar(PaginatedRequest paginatedRequest) {
        PageRequest pageRequest = PageRequest.of(paginatedRequest.getCurrentPage(), paginatedRequest.getQuantityPerPage());
        Page<Produto> produtoPage = produtoRepository.findAll(pageRequest);
        return produtoPage.map(ProdutoResponse::new);
    }

    public Produto cadastrar(ProdutoRequest request) {
        Produto produto = Produto.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .preco(request.getPreco())
                .fornecedores(getFornecedores(request.getFornecedores()))
                .build();
        List<Fornecedor> fornecedores = getFornecedores(request.getFornecedores());
        fornecedores.forEach(fornecedor -> {
            fornecedor.getProdutos().add(produto);});
        return produtoRepository.save(produto);
    }

    public Page<MovelResponse> listarMoveis(PaginatedRequest paginatedRequest) {
        PageRequest pageRequest = PageRequest.of(paginatedRequest.getCurrentPage(), paginatedRequest.getQuantityPerPage());
        Page<Movel> movelPage = movelRepository.findAll(pageRequest);
        return movelPage.map(MovelResponse::new);
    }

    public Movel cadastrarMovel(MovelRequest request) {
        Movel movel = new Movel();
        generateMovel(movel, request);
        List<Fornecedor> fornecedores = getFornecedores(request.getFornecedores());
        fornecedores.forEach(fornecedor -> {
            fornecedor.getProdutos().add(movel);});
        return movelRepository.save(movel);
    }

    public List<Movel> getMovelByNome(String nome) {
        return movelRepository.findByNome(nome);
    }
    public List<Produto> getProdutoByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Produto updateProduto(ProdutoRequest request, Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        produto.setFornecedores(getFornecedores(request.getFornecedores()));
        return produtoRepository.save(produto);
    }

    public Movel updateMovel(MovelRequest request, Long id) {
        Movel movel = movelRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
        generateMovel(movel, request);
        return movelRepository.save(movel);
    }

    public List<Fornecedor> getFornecedoresByProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new).getFornecedores();
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    private List<Fornecedor> getFornecedores(List<Long> fornecedorIds) {
        return fornecedorIds.stream().map(id -> fornecedorRepository.findById(id).orElseThrow(FornecedorNotFoundException::new)).toList();
    }

    private void generateMovel(Movel movel, MovelRequest request) {
        movel.setNome(request.getNome());
        movel.setDescricao(request.getDescricao());
        movel.setPreco(request.getPreco());
        movel.setFornecedores(getFornecedores(request.getFornecedores()));
        movel.setTipoMadeira(request.getTipoMadeira());
        movel.setDimensoes(request.getDimensoes());
    }
}
