package br.com.crud_produtos.controllers;

import br.com.crud_produtos.model.dto.ProdutoRequestDto;
import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import br.com.crud_produtos.services.impl.ProdutoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    private final ProdutoServiceImpl service;

    public ProdutoController(ProdutoServiceImpl produtoService) {
        this.service = produtoService;
    }

    @Operation(summary = "Buscar todos os produtos")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> findAll() {
        logger.info("::: Buscando todos os produtos cadastrados :::");
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Cadastrar novo Produto")
    @PostMapping
    public ResponseEntity<ProdutoResponseDto> save(@RequestBody ProdutoRequestDto dto){
        logger.info("::: Salvando novo produto {} ::: ");
        return ResponseEntity.ok(service.save(dto));

    }



}
