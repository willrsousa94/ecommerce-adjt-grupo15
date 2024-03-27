package com.FiapEShopping.services;

import java.util.Optional;
import java.util.UUID;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Item;
import com.FiapEShopping.model.User;

public interface CarrinhoDeComprasService {
    CarrinhoDeCompras criarCarrinho(User user);
    CarrinhoDeCompras  adicionarItem(UUID carrinhoId, Item item);
    Optional<CarrinhoDeCompras> obterCarrinho(UUID id);
    CarrinhoDeCompras salvarCarrinho (CarrinhoDeCompras carrinho);
    
    
}
