package com.loja_moveis.controller;

import com.loja_moveis.domain.dto.PaginatedRequest;
import com.loja_moveis.domain.dto.fornecedor.FornecedorResponse;
import com.loja_moveis.domain.dto.produto.ProdutoRequest;
import com.loja_moveis.domain.dto.produto.ProdutoResponse;
import com.loja_moveis.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/{id}")
//    public ResponseEntity<FornecedorResponse> getById(@PathVariable Long id) {
//        return ResponseEntity.ok(new FornecedorResponse(service.getById(id)));
//    }
//
//    @PostMapping("/cadastrar")
//    public ResponseEntity<FornecedorResponse> cadastrar(@RequestBody FornecedorRequest request) {
//        return ResponseEntity.ok(new FornecedorResponse(service.cadastrar(request)));
//    }
//
//    @PostMapping("/update/{id}")
//    public ResponseEntity<FornecedorResponse> update(@RequestBody FornecedorRequest request, @PathVariable Long id) {
//        return ResponseEntity.ok(new FornecedorResponse(service.update(request, id)));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleterById(@PathVariable Long id) {
//        return ResponseEntity.noContent().build();
//    }
}
