package br.com.cartoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartoes.controller.entrada.EntradaCartao;
import br.com.cartoes.entity.Cartao;
import br.com.cartoes.entity.Cliente;
import br.com.cartoes.repository.CartaoRepository;
import br.com.cartoes.repository.ClienteRepository;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository repository;

	@Autowired
	ClienteRepository clienteRepository;

	public Cartao criar(EntradaCartao entradaCartao) {

		Optional<Cliente> cliente = clienteRepository.findById(entradaCartao.getClienteId());

		if (cliente.isPresent()) {
			Cartao cartao = new Cartao();
			cartao.setNumero(entradaCartao.getNumero());
			cartao.setClienteId(cliente.get());
			return repository.save(cartao);
		}
		
		return null;
	}


	public Cartao buscarPorId(Long id) {
		Optional<Cartao> optionalCartao = repository.findById(id);

		return optionalCartao.get();
	}

	public Cartao atualizar(String numeroCartao, EntradaCartao entradaCartao) {
		List<Cartao> listaCartao = repository.buscaPorNumero(numeroCartao);

		Optional<Cartao> optionalCartao = listaCartao.stream().findFirst();

		if (optionalCartao.isPresent()) {
			Cartao cartaoRetornado = optionalCartao.get();
			cartaoRetornado.setAtivo(entradaCartao.isAtivo());

			Cartao cartao = repository.save(cartaoRetornado);
			return cartao;
		}

		return null;
	}
}
