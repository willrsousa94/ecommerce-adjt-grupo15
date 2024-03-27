package com.FiapEShopping.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemCarrinho {

	@EmbeddedId
    private ItemCarrinhoId id;

    @ManyToOne
    @MapsId("idCarrinho")
    @JoinColumn(name = "id_carrinho")
    private CarrinhoDeCompras carrinho;

    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name = "id_item")
    private Item item;

	private int quantidadeItemPorCarrinho;

	

}
