package com.ecommerce.organicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.organicos.model.Usuarios;
import com.ecommerce.organicos.repository.UsuariosRepository;

@Service
public class UsuarioService {

	@Autowired
	public UsuariosRepository repository;
	
	public List<Usuarios> listarTodos(){
		return repository.findAll();
	}
	
	public Optional<Usuarios> buscarPorId(Long id){
		return repository.findById(id);
	}
	public List<Usuarios> buscarPorNome (String nome){
		return repository.findAllByNomeContainingIgnoreCase(nome);
	}
	public List<Usuarios> buscarPorRegiao (String regiao){
		return repository.findAllByEnderecoContainingIgnoreCase(regiao);
	}
	public Usuarios postar(Usuarios usuarios) {
		return repository.save(usuarios);	
	}
	public Optional<Usuarios> alterar (Usuarios usuarios) {
		Optional<Usuarios> existente = repository.findById(usuarios.getId());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			existente.get().setRazaoSocial(usuarios.getRazaoSocial());
			existente.get().setNome(usuarios.getNome());
			existente.get().setCnpj(usuarios.getCnpj());
			existente.get().setCpf(usuarios.getCpf());
			existente.get().setEndereco(usuarios.getEndereco());
			existente.get().setTelefone(usuarios.getTelefone());
		}
		return Optional.ofNullable(repository.save(existente.get()));
	}
	
	public Optional<Usuarios> alterarLogin(Usuarios usuarios) {
		Optional<Usuarios> existente = repository.findById(usuarios.getId());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			existente.get().setEmail(usuarios.getEmail());
			existente.get().setSenha(usuarios.getSenha());
		}
		return Optional.ofNullable(repository.save(existente.get()));
	}
	
	public void deletar (Usuarios usuarios) {
		repository.deleteById(usuarios.getId());
	}
	
}
