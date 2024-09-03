package com.loja_moveis.controller;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorResponse;
import com.loja_moveis.domain.dto.produto.MovelRequest;
import com.loja_moveis.domain.dto.produto.MovelResponse;
import com.loja_moveis.domain.dto.produto.ProdutoRequest;
import com.loja_moveis.domain.dto.produto.ProdutoResponse;
import com.loja_moveis.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService service;

    @Operation(summary = "Lista todos os produtos de forma paginada")
    @GetMapping("/list")
    public ResponseEntity<Page<ProdutoResponse>> listar(PaginatedRequest paginatedRequest) {
        return ResponseEntity.ok(service.listar(paginatedRequest));
    }

    @Operation(summary = "Cadastra um novo produto")
    @PostMapping("/cadastrar-produto")
    public ResponseEntity<ProdutoResponse> cadastrar(@RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(new ProdutoResponse(service.cadastrar(request)));
    }

    @Operation(summary = "Cadastra um novo movel")
    @PostMapping("/cadastrar-movel")
    public ResponseEntity<MovelResponse> cadastrar(@RequestBody MovelRequest request) {
        return ResponseEntity.ok(new MovelResponse(service.cadastrarMovel(request)));
    }

    @Operation(summary = "Pesquisa um produto pelo nome")
    @GetMapping("/{nome}")
    public ResponseEntity<List<ProdutoResponse>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.getProdutoByNome(nome).stream().map(ProdutoResponse::new).toList());
    }
    @Operation(summary = "Edita um produto")
    @PostMapping("/update-produto/{id}")
    public ResponseEntity<ProdutoResponse> update(@RequestBody ProdutoRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(new ProdutoResponse(service.updateProduto(request, id)));
    }

    @Operation(summary = "Edita um movel")
    @PostMapping("/update-movel/{id}")
    public ResponseEntity<MovelResponse> update(@RequestBody MovelRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(new MovelResponse(service.updateMovel(request, id)));
    }

    @GetMapping("/{id}/fornecedores")
    public ResponseEntity<List<FornecedorResponse>> getByNome(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFornecedoresByProduto(id).stream().map(FornecedorResponse::new).toList());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleterById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
