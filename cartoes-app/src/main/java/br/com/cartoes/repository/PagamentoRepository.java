package br.com.cartoes.repository;

import br.com.cartoes.Entity.Pagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {




}
