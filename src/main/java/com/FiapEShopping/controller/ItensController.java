package com.FiapEShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FiapEShopping.model.Item;
import com.FiapEShopping.services.ItensService;

@RestController
public class ItensController {
	
	@Autowired
	ItensService service;
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarItem(@RequestBody Item obj){
		Item novoItem = service.save(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
		
	}
	
	
	@GetMapping("/listarItens")
	public ResponseEntity<?> listarItens(){
		List<Item> listaDeItens = service.buscarTodosItens();
		return ResponseEntity.ok(listaDeItens);
		
	}


}
