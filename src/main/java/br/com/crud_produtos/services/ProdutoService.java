package br.com.crud_produtos.services;

import br.com.crud_produtos.model.dto.ProdutoRequestDto;
import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {

    List<ProdutoResponseDto> findAll();

    ProdutoResponseDto save(ProdutoRequestDto dto);
}
