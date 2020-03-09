package br.com.cartoes.service;

import br.com.cartoes.Entity.Cartao;
import br.com.cartoes.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CartaoService {

    @Autowired
    CartaoRepository repository;

    public Cartao criar(Cartao cartao){
        return repository.save(cartao);
    }


    public Boolean atualizar(Cartao cartao){
        Optional<Cartao> cartaoOptional = repository.findById(cartao.getId());

        if(cartaoOptional.isPresent()){
            Cartao cartaoRetornado = cartaoOptional.get();
            cartaoRetornado.setAtivo(cartao.isAtivo());
            repository.save(cartaoRetornado);
            return cartao.isAtivo()g;
        }

        return false;



    }
}
