package br.com.crud_produtos.model.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProdutoRequestDto
        (
                String descricao,
                String fabricante,
                Double preco
        ) {


}
