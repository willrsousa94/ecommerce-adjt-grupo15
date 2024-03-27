package com.FiapEShopping.services;


import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Pagamento;

@Service
public class PagamentoService {

    private final CarrinhoDeComprasService carrinhoDeComprasService;

    @Autowired
    public PagamentoService(CarrinhoDeComprasService carrinhoDeComprasService) {
        this.carrinhoDeComprasService = carrinhoDeComprasService;
    }

    public boolean processarPagamento(UUID carrinhoId, Pagamento pagamento) {
        // Verificar se o carrinho existe
        Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasService.obterCarrinho(carrinhoId);
        if (optionalCarrinho.isPresent()) {
            CarrinhoDeCompras carrinho = optionalCarrinho.get();
            // Verificar se o valor do pagamento corresponde ao total do carrinho
            BigDecimal totalDoCarrinho = carrinho.getTotal();
            if (pagamento.getValor().compareTo(totalDoCarrinho) == 0) {
                // Atualizar o estado do carrinho para marcá-lo como pago
                carrinho.setPago(true);
                
                // Salvar as alterações no carrinho de compras
                carrinhoDeComprasService.salvarCarrinho(carrinho);
                
                // Retornar true para indicar que o pagamento foi efetuado com sucesso
                return true;
            }
        }
        return false;
    }
}