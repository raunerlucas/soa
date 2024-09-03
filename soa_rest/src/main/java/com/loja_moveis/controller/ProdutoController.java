package com.loja_moveis.controller;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorResponse;
import com.loja_moveis.domain.dto.produto.MovelResponse;
import com.loja_moveis.domain.dto.produto.ProdutoRequest;
import com.loja_moveis.domain.dto.produto.ProdutoResponse;
import com.loja_moveis.service.ProdutoService;
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
    @GetMapping("/list")
    public ResponseEntity<Page<ProdutoResponse>> listar(PaginatedRequest paginatedRequest) {
        return ResponseEntity.ok(service.listar(paginatedRequest));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoResponse> cadastrar(@RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(new ProdutoResponse(service.cadastrar(request)));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<ProdutoResponse>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.getProdutoByNome(nome).stream().map(ProdutoResponse::new).toList());
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProdutoResponse> update(@RequestBody ProdutoRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(new ProdutoResponse(service.updateProduto(request, id)));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleterById(@PathVariable Long id) {
//        return ResponseEntity.noContent().build();
//    }
}
