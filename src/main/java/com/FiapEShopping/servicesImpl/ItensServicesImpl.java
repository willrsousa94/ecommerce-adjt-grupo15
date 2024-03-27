package com.FiapEShopping.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapEShopping.model.Item;
import com.FiapEShopping.repositories.ItensRepository;
import com.FiapEShopping.services.ItensService;

@Service
public class ItensServicesImpl implements ItensService{

	@Autowired
	ItensRepository repo;
	
	@Override
	public Item save(Item item) {
		return repo.save(item);
	}

	@Override
	public List<Item> buscarTodosItens() {
		return repo.findAll();
	}

	@Override
	public Optional<Item> buscarPorId(UUID id) {
		return repo.findById(id);
	}

	@Override
	public void deletarAparelho(UUID id) {
		repo.deleteById(id);
		
	}

}
