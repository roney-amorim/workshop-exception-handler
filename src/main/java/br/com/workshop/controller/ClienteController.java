package br.com.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshop.entity.Cliente;
import br.com.workshop.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteService service;

	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> buscar() {
		return ResponseEntity.ok(this.service.buscarClientes());
	}

	@GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorCodigo(@PathVariable("codigo") Integer codigo) {
		return ResponseEntity.ok(this.service.buscarPorCodigo(codigo));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(this.service.cadastrar(cliente));
	}

	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(this.service.alterar(cliente));
	}

	@DeleteMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> delete(@PathVariable("codigo") Integer codigo) {
		this.service.remover(codigo);
		return ResponseEntity.ok().build();
	}
}
