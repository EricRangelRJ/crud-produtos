package br.com.crud_produtos.controllers;

import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import br.com.crud_produtos.services.impl.ProdutoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    private final ProdutoServiceImpl service;

    public ProdutoController(ProdutoServiceImpl produtoService) {
        this.service = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> findAll() {
        logger.info("::: Buscando todos os produtos cadastrados :::");
        return ResponseEntity.ok(service.findAll());
    }



}
