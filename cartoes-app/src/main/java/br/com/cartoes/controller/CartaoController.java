package br.com.cartoes.controller;

import br.com.cartoes.entity.Cliente;
import br.com.cartoes.entity.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cartoes.controller.entrada.EntradaCartao;
import br.com.cartoes.entity.Cartao;
import br.com.cartoes.service.CartaoService;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
	
	@Autowired
	CartaoService service;
	
	@PostMapping()
	public ResponseEntity<Cartao> criar(@RequestBody EntradaCartao entradaCartao) {
		return new ResponseEntity<Cartao>(service.criar(entradaCartao), new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{numero}")
	public ResponseEntity<Cartao> atualizar(@PathVariable("numero") String numero, @RequestBody EntradaCartao entradaCarta) {
		 
		return new ResponseEntity<Cartao>(service.atualizar(numero, entradaCarta), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{numero}")
	public List<Cartao> buscarPorNumero(@PathVariable("numero") String id) {
		return service.buscaPorNumero(id);
	}

}
