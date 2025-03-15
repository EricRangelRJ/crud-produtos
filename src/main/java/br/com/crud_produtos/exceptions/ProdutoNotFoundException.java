package br.com.crud_produtos.exceptions;

import java.util.UUID;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(UUID uuid) {
        super("Produto não encontrado com o id " + uuid + " informado!");
    }

}
