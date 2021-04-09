package com.ecommerce.organicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.repository.ProdutosRepository;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutosRepository repository;
	
	public List<Produtos> listarTodos(){
		return repository.findAll();
	}
	
	public Optional<Produtos> buscarPorId(Long id){
		return repository.findById(id);
	}
	
	public List<Produtos> listarOrganicos(boolean organico){
		return repository.findAllByOrganico(organico);
	}
	
	public Produtos postar(Produtos produtos) {
		return repository.save(produtos);
		
	}
	
	public Optional<Produtos> alterar(Produtos produtos) {
		Optional<Produtos> existente = repository.findById(produtos.getIdProduto());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			existente.get().setCategoriaDoProduto(produtos.getCategoriaDoProduto());
			existente.get().setDataSafra(produtos.getDataSafra());
			existente.get().setDescricao(produtos.getDescricao());
			existente.get().setNome(produtos.getNome());
			existente.get().setOrganico(produtos.getOrganico());
			existente.get().setPreco(produtos.getPreco());
		}
		   return Optional.ofNullable(repository.save(existente.get()));
	}	
}	

