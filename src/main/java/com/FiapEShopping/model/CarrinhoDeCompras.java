package com.FiapEShopping.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.el.lang.ELArithmetic.BigDecimalDelegate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class CarrinhoDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private boolean pago; 
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    
    private BigDecimal total;

    public CarrinhoDeCompras(User user) {
        this.user = user;
        this.total = BigDecimal.ZERO;
    }

    public void adicionarItem( BigDecimal valorItem) {
        total = total.add(valorItem);
    }


}