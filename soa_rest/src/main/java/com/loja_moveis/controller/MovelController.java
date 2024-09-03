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
    private final MovelService service;
    @GetMapping("/list")
    public ResponseEntity<Page<MovelResponse>> listar(PaginatedRequest paginatedRequest) {
        return ResponseEntity.ok(service.listar(paginatedRequest));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MovelResponse> cadastrar(@RequestBody MovelRequest request) {
        return ResponseEntity.ok(new MovelResponse(service.cadastrar(request)));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<MovelrResponse> getById(@PathVariable Long id) {
//        return ResponseEntity.ok(new MovelResponse(service.getById(id)));
//    }
//
//    @PostMapping("/update/{id}")
//    public ResponseEntity<MovelResponse> update(@RequestBody MovelRequest request, @PathVariable Long id) {
//        return ResponseEntity.ok(new MovelResponse(service.update(request, id)));
//    }
}
