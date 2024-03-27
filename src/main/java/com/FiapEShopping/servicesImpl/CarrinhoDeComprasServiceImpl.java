package com.FiapEShopping.servicesImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Item;
import com.FiapEShopping.model.User;
import com.FiapEShopping.repositories.CarrinhoDeComprasRepository;
import com.FiapEShopping.repositories.ItensRepository;
import com.FiapEShopping.services.CarrinhoDeComprasService;

@Service
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService {
    private final CarrinhoDeComprasRepository carrinhoDeComprasRepository;

    @Autowired
    ItensRepository itensRepository;
    
    @Autowired
    public CarrinhoDeComprasServiceImpl(CarrinhoDeComprasRepository carrinhoDeComprasRepository) {
        this.carrinhoDeComprasRepository = carrinhoDeComprasRepository;
    }

    @Override
    public CarrinhoDeCompras criarCarrinho(User user) {
        return carrinhoDeComprasRepository.save(new CarrinhoDeCompras(user));
    }

	@Override
	public Optional<CarrinhoDeCompras> obterCarrinho(UUID id) {
return carrinhoDeComprasRepository.findById(id);
	}
	
	
    @Override
    public CarrinhoDeCompras adicionarItem(UUID carrinhoId, Item item) {
        Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasRepository.findById(carrinhoId);
        if (optionalCarrinho.isPresent()) {
            CarrinhoDeCompras carrinho = optionalCarrinho.get();
            System.out.println(item.getId());
            Item itemDoBanco = itensRepository.findById(item.getId()).orElse(null);
            if (itemDoBanco != null) {
                carrinho.adicionarItem(itemDoBanco);
                

                int novaQuantidadeEstoque = itemDoBanco.getQuantidadeEstoque() - 1;
                if (novaQuantidadeEstoque >= 0) {
                    itemDoBanco.setQuantidadeEstoque(novaQuantidadeEstoque);
                    itensRepository.save(itemDoBanco);
                } else {
                    
                    
                    return null;
                }
            }
            return carrinhoDeComprasRepository.save(carrinho);
        } else {
            // Lógica de tratamento quando o carrinho não for encontrado
            return null;
        }
    }

	@Override
	public CarrinhoDeCompras salvarCarrinho(CarrinhoDeCompras carrinho) {
		
		return carrinhoDeComprasRepository.save(carrinho);
	}
	
	
	
	
}
