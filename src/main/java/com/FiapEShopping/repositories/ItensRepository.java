package com.FiapEShopping.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapEShopping.model.Item;

public interface ItensRepository extends JpaRepository<Item, UUID >{

}
