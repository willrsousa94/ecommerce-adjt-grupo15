package com.FiapEShopping.model.DTO;

import java.util.List;
import java.util.UUID;

import com.FiapEShopping.model.ItemCarrinho;
import com.FiapEShopping.model.User;

public record CarrinhoDeComprasDTO(UUID id, User user, List<ItemCarrinho> itens) {
	
	
	
}

