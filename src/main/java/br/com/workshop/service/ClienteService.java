package br.com.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshop.entity.Cliente;
import br.com.workshop.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	public List<Cliente> buscarClientes() {
		return this.repository.findAll();
	}

	public Cliente buscarPorCodigo(Integer codigo) {
		return this.repository.findById(codigo).get();
	}

	public Cliente cadastrar(Cliente cliente) {
		return this.repository.save(cliente);
	}

	public Cliente alterar(Cliente cliente) {
		final Cliente entity = this.repository.findById(cliente.getCodigoCliente()).get();

		entity.setNome(cliente.getNome());
		entity.setDocumento(cliente.getDocumento());
		entity.setDataNascimento(cliente.getDataNascimento());

		this.repository.save(entity);

		return entity;
	}

	public void remover(Integer codigo) {
		this.repository.deleteById(codigo);
	}

}
