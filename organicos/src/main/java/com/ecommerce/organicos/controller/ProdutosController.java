package com.ecommerce.organicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutosController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/organicos")
	public ResponseEntity <List<Produtos>> listarOrganicos(@RequestParam(defaultValue = "") boolean organicos){
		return new ResponseEntity <List<Produtos>> (service.listarOrganicos(organicos),HttpStatus.ACCEPTED);
	}
}
