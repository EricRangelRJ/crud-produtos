package br.com.crud_produtos.model.error;

public record ErrorFieldDto(
        String field,
        String message) {
}
