package com.ecommerce.organicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.model.Usuarios;
import com.ecommerce.organicos.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {
	
	@Autowired
	private UsuariosRepository repository;
	
	@GetMapping("/produtores/{nome}")
	public ResponseEntity<List<Produtos>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		
	}
	
	@GetMapping("/produtores/{regiao}")
	public ResponseEntity<List<Usuarios>> getByRegiao(@PathVariable String regiao){
		return ResponseEntity.ok(repository.findAllByEnderecoContainingIgnoreCase(regiao));
	}
}
