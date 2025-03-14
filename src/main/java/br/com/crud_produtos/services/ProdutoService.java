package br.com.crud_produtos.services;

import br.com.crud_produtos.model.dto.ProdutoResponseDto;

import java.util.List;

public interface ProdutoService {

    List<ProdutoResponseDto> findAll();
}
