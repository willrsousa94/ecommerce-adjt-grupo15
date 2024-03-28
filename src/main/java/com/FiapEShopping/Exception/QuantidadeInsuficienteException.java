package com.FiapEShopping.Exception;



public class QuantidadeInsuficienteException extends RuntimeException {
    public QuantidadeInsuficienteException(String mensagem) {
        super(mensagem);
    }
}