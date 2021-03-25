package com.ecommerce.organicos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.repository.ProdutosRepository;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutosRepository repository;
	
	public List<Produtos> listarOrganicos(boolean organico){
		return repository.findAllByOrganico(organico);
	}
}
