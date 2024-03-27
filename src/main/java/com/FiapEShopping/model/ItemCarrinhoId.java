package com.FiapEShopping.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoId implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private UUID idCarrinho;
	private UUID idItem;
}
