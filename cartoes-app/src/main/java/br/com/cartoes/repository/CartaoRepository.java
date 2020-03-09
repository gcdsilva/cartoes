package br.com.cartoes.repository;

import br.com.cartoes.Entity.Cartao;
import br.com.cartoes.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {

}
