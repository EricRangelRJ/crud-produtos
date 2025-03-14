package br.com.crud_produtos.model.entities;

import br.com.crud_produtos.model.dto.ProdutoResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String descricao;

    private String fabricante;

    private Double preco;

    public ProdutoResponseDto toDto() {
        return new ProdutoResponseDto(this.id, this.descricao, this.fabricante, this.preco);
    }


}
