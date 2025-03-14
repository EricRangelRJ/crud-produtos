package br.com.crud_produtos.model.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProdutoResponseDto
        (
                UUID id,
                String descricao,
                String fabricante,
                Double preco
        ) {
}
