package com.FiapEShopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapEShopping.model.ItemCarrinho;
import com.FiapEShopping.model.ItemCarrinhoId;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, ItemCarrinhoId>{

}
