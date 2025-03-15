package br.com.crud_produtos.model.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String detail;
    private String message;
}
