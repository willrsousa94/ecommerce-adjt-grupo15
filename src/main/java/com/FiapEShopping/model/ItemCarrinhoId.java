package com.FiapEShopping.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ItemCarrinhoId implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private UUID idCarrinho;
	private UUID idItem;
}
