package com.ecommerce.organicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.model.Usuarios;
import com.ecommerce.organicos.repository.ProdutosRepository;
import com.ecommerce.organicos.repository.UsuariosRepository;

@Service
public class UsuarioService {

	@Autowired
	public UsuariosRepository repository;
	
	@Autowired
	public ProdutosRepository repositoryProdutos;
	
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
		Optional<Usuarios> existente = repository.findById(usuarios.getIdUsuario());
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
		Optional<Usuarios> existente = repository.findById(usuarios.getIdUsuario());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			existente.get().setEmail(usuarios.getEmail());
			existente.get().setSenha(usuarios.getSenha());
		}
		return Optional.ofNullable(repository.save(existente.get()));
	}
	
	public Produtos cadastrarProduto(Produtos novoProduto, Long idUsuario) {
		Produtos produtoExistente = repositoryProdutos.save(novoProduto);
		Optional<Usuarios> usuarioExistente  = repository.findById(idUsuario);
		if(usuarioExistente.isPresent()) {
			produtoExistente.setCriadoPor(usuarioExistente.get());
			return repositoryProdutos.save(produtoExistente);
		}
		return null;
	}
	
	public Optional<Produtos> editarProduto(Long idUsuario, Produtos produto){
		Optional<Produtos> produtoExistente = repositoryProdutos.findById(produto.getIdProduto());
		Optional<Usuarios> usuarioExistente = repository.findById(idUsuario);
		if(usuarioExistente.isPresent() && produtoExistente.isPresent()) {
			produtoExistente.get().setTitulo(produto.getTitulo());
			produtoExistente.get().setPreco(produto.getPreco());
			produtoExistente.get().setDataSafra(produto.getDataSafra());
			produtoExistente.get().setDescricao(produto.getDescricao());
			produtoExistente.get().setOrganico(produto.getOrganico());
			produtoExistente.get().setCategoria(produto.getCategoria());
			produtoExistente.get().setQtdEstoque(produto.getQtdEstoque());
		}
		return Optional.ofNullable(repositoryProdutos.save(produtoExistente.get()));
	}
	
	
	public Usuarios comprarProduto(Long idUsuario, Long idProduto, int qtdCompras) {
		Optional<Usuarios> usuarioExistente = repository.findById(idUsuario);
		Optional<Produtos> produtoExistente = repositoryProdutos.findById(idProduto);
			if(usuarioExistente.isPresent() && produtoExistente.isPresent()) {
				usuarioExistente.get().getMinhasCompras().add(produtoExistente.get());
				usuarioExistente.get().setValorCompra(produtoExistente.get().getPreco()*qtdCompras);
				return repository.save(usuarioExistente.get());
			}
			return null;
	}
	
	public Usuarios deletarProduto(Long idProduto, Long idUsuario) {
		Optional<Usuarios> usuarioExistente = repository.findById(idUsuario);
		Optional<Produtos> produtoExistente = repositoryProdutos.findById(idProduto);
		if(usuarioExistente.get().getIdUsuario() == produtoExistente.get().getCriadoPor().getIdUsuario()) {
			if(usuarioExistente.isPresent() && produtoExistente.isPresent()) {
				//produtoExistente.get().setCriadoPor(null);
				//repositoryProdutos.save(produtoExistente.get());
				repositoryProdutos.deleteById(produtoExistente.get().getIdProduto());
				return repository.findById(usuarioExistente.get().getIdUsuario()).get();
			}
		}else {
			System.out.println("Somente o usuário criador pode apagar seu próprio produto");
		}
		
		return null;
	}
}
