package com.FiapEShopping.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Item;
import com.FiapEShopping.model.User;
import com.FiapEShopping.services.AuthorizationService;
import com.FiapEShopping.services.CarrinhoDeComprasService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoDeComprasController {
    private final CarrinhoDeComprasService carrinhoDeComprasService;
    private final AuthorizationService authorizationService;

    @Autowired
    public CarrinhoDeComprasController(CarrinhoDeComprasService carrinhoDeComprasService, AuthorizationService authorizationService) {
        this.carrinhoDeComprasService = carrinhoDeComprasService;
        this.authorizationService = authorizationService;
    }

    @PostMapping("/{login}")
    public ResponseEntity<?> criarCarrinho(@PathVariable String login) {
        User user = (User) authorizationService.loadUserByUsername(login);
        CarrinhoDeCompras carrinho = carrinhoDeComprasService.criarCarrinho(user);
        System.out.println(carrinho);
        return ResponseEntity.ok(carrinho);
    }

    @PutMapping("/{carrinhoId}/itens")
    public ResponseEntity<Optional<CarrinhoDeCompras>> adicionarItemAoCarrinho(@PathVariable UUID carrinhoId, @RequestBody Item item) {
        carrinhoDeComprasService.adicionarItem(carrinhoId, item);
        Optional<CarrinhoDeCompras> carrinho = carrinhoDeComprasService.obterCarrinho(carrinhoId); // Supondo que você tenha um método para obter o carrinho pelo ID
        return ResponseEntity.status(HttpStatus.OK).body(carrinho);
    }
}
