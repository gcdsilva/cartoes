package br.com.cartoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartoes.controller.entrada.EntradaCartao;
import br.com.cartoes.entity.Cartao;
import br.com.cartoes.service.CartaoService;

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

}
