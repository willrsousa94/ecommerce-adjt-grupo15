package com.FiapEShopping.servicesImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapEShopping.Exception.QuantidadeInsuficienteException;
import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Item;
import com.FiapEShopping.model.ItemCarrinho;
import com.FiapEShopping.model.ItemCarrinhoId;
import com.FiapEShopping.model.User;
import com.FiapEShopping.model.DTO.CarrinhoDeComprasDTO;
import com.FiapEShopping.repositories.CarrinhoDeComprasRepository;
import com.FiapEShopping.repositories.ItemCarrinhoRepository;
import com.FiapEShopping.repositories.ItensRepository;
import com.FiapEShopping.services.CarrinhoDeComprasService;

@Service
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService {
    private final CarrinhoDeComprasRepository carrinhoDeComprasRepository;


    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;
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
    public CarrinhoDeCompras adicionarItem(UUID idCarrinho, UUID idItem, int quantidade) {
    	ItemCarrinho ic = new ItemCarrinho();
    	ic.setId(new ItemCarrinhoId(idCarrinho, idItem));
        Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasRepository.findById(idCarrinho);
        Optional<Item> itemLocalizado = itensRepository.findById(idItem);
        if (optionalCarrinho.isPresent() && itemLocalizado.isPresent()) {

            CarrinhoDeCompras carrinho = optionalCarrinho.get();
            Item itemDoBanco = itemLocalizado.get();
        	ic.setCarrinho(carrinho);
        	ic.setItem(itemDoBanco);
        	ic.setQuantidadeItemPorCarrinho(quantidade);
            if(itemDoBanco.getQuantidadeEstoque() >= quantidade) {
            	
                carrinho.adicionarItem( itemDoBanco.getPreco().multiply(BigDecimal.valueOf(quantidade)));
                

                int novaQuantidadeEstoque = itemDoBanco.getQuantidadeEstoque() - quantidade;
                itemCarrinhoRepository.save(ic);
                    itemDoBanco.setQuantidadeEstoque(novaQuantidadeEstoque);
                    itensRepository.save(itemDoBanco);
                    return carrinhoDeComprasRepository.save(carrinho);
            }else {
            	throw new QuantidadeInsuficienteException("Quantidade em estoque insuficiente");
            }
           
            //quando não houver quantidade em estoque

        } else {
            // Lógica de tratamento quando o carrinho e/ou Item não for encontrado
            return null;
        }
    }

	@Override
	public CarrinhoDeCompras salvarCarrinho(CarrinhoDeCompras carrinho) {
		
		return carrinhoDeComprasRepository.save(carrinho);
	}
	
	@Override
	public List<CarrinhoDeComprasDTO> findCarrinhoWithItens(UUID carrinhoId) {
	    List<CarrinhoDeComprasDTO> carrinhosDTO = new ArrayList<>();
	    Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasRepository.findById(carrinhoId);
	    if (optionalCarrinho.isPresent()) {
	        CarrinhoDeCompras carrinho = optionalCarrinho.get();
	        List<ItemCarrinho> itens = itemCarrinhoRepository.findByCarrinhoId(carrinho.getId());
	        CarrinhoDeComprasDTO carrinhoDTO = new CarrinhoDeComprasDTO(carrinho.getId(), carrinho.getUser(), itens);
	        carrinhosDTO.add(carrinhoDTO);
	    }
	    return carrinhosDTO;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public CarrinhoDeCompras removerItem(UUID carrinhoId, UUID itemId) {
	    Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasRepository.findById(carrinhoId);
	    Optional<ItemCarrinho> optionalItemCarrinho = itemCarrinhoRepository.findById(new ItemCarrinhoId(carrinhoId, itemId));

	    if (optionalCarrinho.isPresent() && optionalItemCarrinho.isPresent()) {
	        CarrinhoDeCompras carrinho = optionalCarrinho.get();
	        ItemCarrinho itemCarrinho = optionalItemCarrinho.get();

	        // Remover o item do carrinho
	        carrinho.getItens().remove(itemCarrinho);
	        carrinho.setTotal(carrinho.getTotal().subtract(itemCarrinho.getItem().getPreco()));

	        // Atualizar o estoque do item removido
	        Item item = itemCarrinho.getItem();
	        int novaQuantidadeEstoque = item.getQuantidadeEstoque() + itemCarrinho.getQuantidadeItemPorCarrinho();
	        item.setQuantidadeEstoque(novaQuantidadeEstoque);
	        itensRepository.save(item);

	        // Remover o registro de ItemCarrinho
	        itemCarrinhoRepository.delete(itemCarrinho);

	        // Salvar as alterações no carrinho
	        return carrinhoDeComprasRepository.save(carrinho);
	    } else {
	        // Lidar com a situação em que o carrinho ou o item não é encontrado
	        return null;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
