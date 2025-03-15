package br.com.crud_produtos.services;

import br.com.crud_produtos.model.dto.ProdutoRequestDto;
import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProdutoService {

    List<ProdutoResponseDto> findAll();

    ProdutoResponseDto findById(UUID id);

    ProdutoResponseDto save(ProdutoRequestDto dto);

    void delete(UUID uuid);

    ProdutoResponseDto update(ProdutoRequestDto dto);
}
