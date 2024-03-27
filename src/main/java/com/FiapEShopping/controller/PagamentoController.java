package com.FiapEShopping.controller;



import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FiapEShopping.model.Pagamento;
import com.FiapEShopping.services.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
	
    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PutMapping("/{carrinhoId}")
    public ResponseEntity<String> processarPagamento(@PathVariable UUID carrinhoId, @RequestBody Pagamento pagamento) {
        boolean pagamentoEfetuado = pagamentoService.processarPagamento(carrinhoId, pagamento);
        if (pagamentoEfetuado) {
            return ResponseEntity.status(HttpStatus.OK).body("Pagamento efetuado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao processar o pagamento.");
        }
    }
}
