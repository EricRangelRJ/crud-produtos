package br.com.crud_produtos.model.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record ErrorDto(
        String title,
        String message,
        String code,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<ErrorFieldDto> fields) {
}
