package br.com.crud_produtos.repositories;

import br.com.crud_produtos.model.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
}
