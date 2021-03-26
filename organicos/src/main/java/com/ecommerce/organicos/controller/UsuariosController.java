package com.ecommerce.organicos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.model.Usuarios;
import com.ecommerce.organicos.repository.UsuariosRepository;
import com.ecommerce.organicos.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuarios>> listarTodos() {
		return new ResponseEntity<List<Usuarios>>(service.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuarios>> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Optional<Usuarios>>(service.buscarPorId(id), HttpStatus.OK);
	}

	@GetMapping("/produtores/{nome}")
	public ResponseEntity<List<Usuarios>> getByName(@RequestParam(defaultValue = "") String nome) {
		return new ResponseEntity<List<Usuarios>>(service.buscarPorNome(nome), HttpStatus.OK);

	}

	@GetMapping("/produtores/{regiao}")
	public ResponseEntity<List<Usuarios>> getByRegiao(@RequestParam(defaultValue = "") String regiao) {
		return new ResponseEntity<List<Usuarios>>(service.buscarPorRegiao(regiao), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Usuarios> postar(@RequestBody Usuarios usuarios) {
		return new ResponseEntity<Usuarios>(service.postar(usuarios), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> alterar(@RequestBody Usuarios usuarios) {
		Optional<Usuarios> alterado = service.alterar(usuarios);
		if (alterado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário Inexistente");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(alterado.get());
		}
	}

	@PutMapping("/alterar/login")
	public ResponseEntity<?> alterarLogin(@RequestBody Usuarios usuarios) {
		Optional<Usuarios> alterado = service.alterarLogin(usuarios);
		if (alterado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário Inexistente");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(alterado.get());
		}
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(Usuarios usuarios) {
		service.deletar(usuarios);
	}
}
