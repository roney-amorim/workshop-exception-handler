package br.com.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshop.entity.Produto;
import br.com.workshop.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<Produto> buscarProdutos() {
		return this.repository.findAll();
	}

	public Produto buscarPorCodigo(Integer codigo) {
		return this.repository.findById(codigo).get();
	}

	public Produto cadastrar(Produto produto) {
		return this.repository.save(produto);
	}

	public Produto alterar(Produto produto) {
		final Produto entity = this.repository.findById(produto.getCodigoProduto()).get();

		entity.setDescricao(produto.getDescricao());
		entity.setNome(produto.getNome());
		entity.setDataValidade(produto.getDataValidade());
		entity.setPreco(produto.getPreco());

		this.repository.save(entity);

		return entity;
	}

	public void remover(Integer codigo) {
		this.repository.deleteById(codigo);
	}

}
