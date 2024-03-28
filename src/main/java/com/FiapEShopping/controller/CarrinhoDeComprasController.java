package com.FiapEShopping.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FiapEShopping.model.CarrinhoDeCompras;
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

    @PutMapping("/adicionarItemCarrinho")
    public ResponseEntity<CarrinhoDeCompras> adicionarItemAoCarrinho(@RequestBody Map<String, String> requestBody) {
        String idCarrinhoStr = requestBody.get("idCarrinho");
        String idItemStr = requestBody.get("idItem");
        String quantidadeStr = requestBody.get("quantidade");

        UUID idCarrinho = UUID.fromString(idCarrinhoStr);
        UUID idItem = UUID.fromString(idItemStr);
        int quantidade = Integer.parseInt(quantidadeStr);

        CarrinhoDeCompras carrinhoDeCompras = carrinhoDeComprasService.adicionarItem(idCarrinho, idItem, quantidade);
        return ResponseEntity.status(HttpStatus.OK).body(carrinhoDeCompras);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDeCompras> listarCarrinhos(@PathVariable UUID id) {
        CarrinhoDeCompras carrinhos = (CarrinhoDeCompras) carrinhoDeComprasService.findCarrinhoWithItens(id);
        System.out.println(carrinhos);
        return ResponseEntity.status(HttpStatus.OK).body(carrinhos);
    
    }
    

    
    @DeleteMapping("/removerItemCarrinho/{carrinhoId}/{itemId}")
    public ResponseEntity<CarrinhoDeCompras> removerItemDoCarrinho(@PathVariable UUID carrinhoId, @PathVariable UUID itemId) {
        CarrinhoDeCompras carrinhoDeCompras = carrinhoDeComprasService.removerItem(carrinhoId, itemId);
        if (carrinhoDeCompras != null) {
            return ResponseEntity.ok(carrinhoDeCompras);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    
    
    
}
