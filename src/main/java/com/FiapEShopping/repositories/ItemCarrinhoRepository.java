package com.FiapEShopping.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapEShopping.model.ItemCarrinho;
import com.FiapEShopping.model.ItemCarrinhoId;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, ItemCarrinhoId>{

	 List<ItemCarrinho> findByCarrinhoId(UUID carrinhoId);
}
