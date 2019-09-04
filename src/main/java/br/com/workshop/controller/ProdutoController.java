package br.com.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshop.entity.Produto;
import br.com.workshop.service.ProdutoService;

@CrossOrigin(origins = "*", maxAge = 4200)
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> buscar() {
		return ResponseEntity.ok(this.service.buscarProdutos());
	}

	@GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> buscarPorCodigo(@PathVariable("codigo") Integer codigo) {
		return ResponseEntity.ok(this.service.buscarPorCodigo(codigo));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
		return ResponseEntity.ok(this.service.cadastrar(produto));
	}

	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto) {
		return ResponseEntity.ok(this.service.alterar(produto));
	}

	@DeleteMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> alterar(@PathVariable("codigo") Integer codigo) {
		this.service.remover(codigo);
		return ResponseEntity.ok().build();
	}
}
