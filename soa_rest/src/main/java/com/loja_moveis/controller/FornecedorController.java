package com.loja_moveis.controller;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorResponse;
import com.loja_moveis.domain.dto.produto.ProdutoResponse;
import com.loja_moveis.service.FornecedorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/fornecedor")
public class FornecedorController {
    private final FornecedorService service;
    @GetMapping("/list")
    public ResponseEntity<Page<FornecedorResponse>> listar(PaginatedRequest paginatedRequest) {
        return ResponseEntity.ok(service.listar(paginatedRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new FornecedorResponse(service.getById(id)));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<FornecedorResponse> cadastrar(@RequestBody FornecedorRequest request) {
        return ResponseEntity.ok(new FornecedorResponse(service.cadastrar(request)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<FornecedorResponse> update(@RequestBody FornecedorRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(new FornecedorResponse(service.update(request, id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/produtos")
    public ResponseEntity<List<ProdutoResponse>> getProdutos(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProdutos(id).stream().map(ProdutoResponse::new).toList());
    }
}
