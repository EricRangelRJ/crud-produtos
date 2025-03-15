package br.com.crud_produtos.services.impl;

import br.com.crud_produtos.exceptions.ProdutoNotFoundException;
import br.com.crud_produtos.model.dto.ProdutoRequestDto;
import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import br.com.crud_produtos.model.entities.ProdutoEntity;
import br.com.crud_produtos.repositories.ProdutoRepository;
import br.com.crud_produtos.services.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
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

    @Override
    public ProdutoResponseDto findById(UUID id) {
        Optional<ProdutoEntity> result = produtoRepository.findById(id);
        return result.map(ProdutoEntity::toDto)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    @Override
    public ProdutoResponseDto save(ProdutoRequestDto dto) {
        ProdutoEntity produtoEntity = ProdutoEntity.toEntity(dto);
        return produtoRepository.save(produtoEntity).toDto();
    }

    @Override
    public void delete(UUID uuid) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(uuid);
        if (produto.isPresent()){
            produtoRepository.delete(new ProdutoEntity(uuid));
        } else {
            throw new ProdutoNotFoundException(uuid);
        }
    }

    @Override
    public ProdutoResponseDto update(ProdutoRequestDto dto) {
        UUID produtoId = dto.id(); // Guardando o id para evitar repetições
        Optional<ProdutoEntity> produto = produtoRepository.findById(produtoId);
        if (produto.isPresent()) {
            ProdutoEntity produtoAtualizado = ProdutoEntity.toEntity(dto);
            return produtoRepository.save(produtoAtualizado).toDto();
        } else {
            throw new ProdutoNotFoundException(produtoId); // Passando o id na exceção
        }
    }


}
