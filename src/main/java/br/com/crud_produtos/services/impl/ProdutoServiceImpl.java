package br.com.crud_produtos.services.impl;

import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import br.com.crud_produtos.model.entities.ProdutoEntity;
import br.com.crud_produtos.repositories.ProdutoRepository;
import br.com.crud_produtos.services.ProdutoService;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoResponseDto> findAll() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos
                .stream()
                .map(ProdutoEntity::toDto)
                .collect(Collectors.toList());
    }
}
