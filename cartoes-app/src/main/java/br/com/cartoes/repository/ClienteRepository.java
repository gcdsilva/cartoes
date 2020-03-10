package br.com.cartoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cartoes.entity.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
