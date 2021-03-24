package com.ecommerce.organicos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	private CategoriaRepository repository;

	@GetMapping("/organicos")
	public ResponseEntity <List<Produtos>> getByCategoria(String categoria) {
		return ResponseEntity.ok(repository.findAllByOrganico(categoria));
	}
}
