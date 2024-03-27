package com.FiapEShopping.services;

import java.util.Optional;
import java.util.UUID;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Item;
import com.FiapEShopping.model.ItemCarrinho;
import com.FiapEShopping.model.User;

public interface CarrinhoDeComprasService {
    CarrinhoDeCompras criarCarrinho(User user);
    Optional<CarrinhoDeCompras> obterCarrinho(UUID id);
    CarrinhoDeCompras salvarCarrinho (CarrinhoDeCompras carrinho);
	CarrinhoDeCompras adicionarItem( UUID idCarrinho, UUID idItem,  int quantidade);
    
    
}
