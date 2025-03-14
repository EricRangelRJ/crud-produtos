package br.com.crud_produtos.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ProdutoRequestDto
        (
                @Schema(description = "descricao", example = "Teclado mecânico")
                String descricao,
                @Schema(description = "fabricante", example = "Logitech")
                String fabricante,
                @Schema(description = "preçco", example = "249.99")
                Double preco
        ) {


}
