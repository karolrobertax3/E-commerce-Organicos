package com.ecommerce.organicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.model.util.Categoria;
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
	
	 public List<Produtos> listarCategoria(Categoria categoria){
	 	return repository.findByCategoria(categoria);
	 }

		
	public List<Produtos> buscarPorTitulo(String titulo){
		return repository.findAllByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Produtos> filtrarPorPreco(float preco1, float preco2){
		return repository.findByPrecoBetween(preco1, preco2);
	}
	
}