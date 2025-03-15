package br.com.crud_produtos.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ProdutoRequestDto
        (
                @Schema(description = "uuid", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
                UUID id,
                @Schema(description = "descricao", example = "Teclado mecânico")
                String descricao,
                @Schema(description = "fabricante", example = "Logitech")
                String fabricante,
                @Schema(description = "preçco", example = "249.99")
                Double preco
        ) {


}
