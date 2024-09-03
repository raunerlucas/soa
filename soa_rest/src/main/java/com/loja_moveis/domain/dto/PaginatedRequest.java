package com.loja_moveis.domain.dto;

import lombok.Data;

@Data
public class PaginatedRequest {
    private Integer currentPage;
    private Integer quantityPerPage;
}
