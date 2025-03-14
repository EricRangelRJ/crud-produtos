package br.com.crud_produtos.model.entities;

import br.com.crud_produtos.model.dto.ProdutoRequestDto;
import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column
    private String descricao;

    @Column
    private String fabricante;

    @Column
    private Double preco;

    public ProdutoResponseDto toDto() {
        return new ProdutoResponseDto(this.id, this.descricao, this.fabricante, this.preco);
    }

    public static ProdutoEntity toEntity(ProdutoRequestDto dto) {
        return new ProdutoEntity(null, dto.descricao(), dto.fabricante(), dto.preco());
    }

    public ProdutoEntity() {
    }

    public ProdutoEntity(UUID id, String descricao, String fabricante, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.preco = preco;
    }
}
