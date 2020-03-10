package br.com.cartoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartoes.controller.entrada.EntradaPagamento;
import br.com.cartoes.entity.Cartao;
import br.com.cartoes.entity.Pagamento;
import br.com.cartoes.repository.CartaoRepository;
import br.com.cartoes.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	PagamentoRepository repository;
	
	@Autowired
	CartaoRepository repositoryCartao;
	
	public Pagamento criar(EntradaPagamento entradaPagamento) {
		
		Optional<Cartao> cartaoOptional = repositoryCartao.findById(entradaPagamento.getCartao_id());
		
		
		if(cartaoOptional.isPresent() && cartaoOptional.get().isAtivo()) {
			Pagamento pagamento = new Pagamento();
			pagamento.setCartao(cartaoOptional.get());
			pagamento.setDescricao(entradaPagamento.getDescricao());
			pagamento.setValor(entradaPagamento.getValor());
			return repository.save(pagamento);
		}
		
		return null;
		
	}
	
	
	public List<Pagamento> buscarPorCartao(Long id) {
		
		List<Pagamento> listaPagamento = repository.buscaPorCartao(id);
		
		return listaPagamento;
		
	}

}
