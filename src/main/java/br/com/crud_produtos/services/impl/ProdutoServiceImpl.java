package br.com.crud_produtos.services.impl;

import br.com.crud_produtos.model.dto.ProdutoRequestDto;
import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import br.com.crud_produtos.model.entities.ProdutoEntity;
import br.com.crud_produtos.repositories.ProdutoRepository;
import br.com.crud_produtos.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final ModelMapper modelMapper;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProdutoResponseDto> findAll() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos
                .stream()
                .map(ProdutoEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoResponseDto save(ProdutoRequestDto dto) {
        ProdutoEntity produtoEntity = ProdutoEntity.toEntity(dto);
        return produtoRepository.save(produtoEntity).toDto();
    }

    @Override
    public void delete(UUID uuid) {
        produtoRepository.delete(new ProdutoEntity(uuid));
    }
}
