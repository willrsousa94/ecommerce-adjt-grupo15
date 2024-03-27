package com.FiapEShopping.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.FiapEShopping.model.Item;

@Service
public interface ItensService {
	
	Item save (Item item);
	List<Item> buscarTodosItens();
	Optional<Item> buscarPorId(UUID id);
	void deletarAparelho (UUID id);
	

}
