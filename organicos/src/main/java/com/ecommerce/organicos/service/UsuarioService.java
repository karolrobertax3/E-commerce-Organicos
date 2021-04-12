package com.ecommerce.organicos.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.model.UsuarioLogin;
import com.ecommerce.organicos.model.Usuarios;
import com.ecommerce.organicos.repository.ProdutosRepository;
import com.ecommerce.organicos.repository.UsuariosRepository;

@Service
public class UsuarioService {

	@Autowired
	public UsuariosRepository repository;
	
	@Autowired
	public ProdutosRepository repositoryProdutos;
	
	public Optional<Usuarios> cadastrar(Usuarios usuario) {
        Optional<Usuarios> usuarioExistente = repository.findByEmail(usuario.getEmail());
        if(usuarioExistente.isPresent()) {
            return Optional.empty();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return Optional.ofNullable(repository.save(usuario));
    }
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> usuarioLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuarios> usuarioPresente = repository.findByEmail(usuarioLogin.get().getEmail());

		if(usuarioPresente.isPresent()) {
			if(encoder.matches(usuarioLogin.get().getSenha(), usuarioPresente.get().getSenha())) {
				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				usuarioLogin.get().setToken(authHeader);				
				usuarioLogin.get().setNome(usuarioPresente.get().getNomeRazaoSocial());
				usuarioLogin.get().setSenha(usuarioPresente.get().getSenha());

				return usuarioLogin;
			}
		}
		return null;
	}
	
	public Produtos cadastrarProduto(Produtos novoProduto, Long idUsuario) {
		Produtos produtoExistente = repositoryProdutos.save(novoProduto);
		Optional<Usuarios> usuarioExistente  = repository.findById(idUsuario);
		if(usuarioExistente.isPresent()) {
			produtoExistente.setCriadoPor(usuarioExistente.get());
			usuarioExistente.get().setDoacao(produtoExistente.getPreco() * 0.05);
			if(produtoExistente.getQtdEstoque()>0) {
				produtoExistente.setAtivo(true);
			}
			
			return repositoryProdutos.save(produtoExistente);
		}
		return null;
	}
	
	public List<Usuarios> buscarProdutorPorNome (String nome){
		return repository.findUsuariosByNomeRazaoSocial(nome);
		
	}
	
	public List<Usuarios> buscarProdutorPorRegiao (String regiao){
		return repository.findUsuariosByEndereco(regiao);
	}
	
	
	public Optional<Usuarios> alterar (Usuarios usuarios) {
		Optional<Usuarios> existente = repository.findById(usuarios.getIdUsuario());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			existente.get().setNomeRazaoSocial(usuarios.getNomeRazaoSocial());
			existente.get().setCpfCnpj(usuarios.getCpfCnpj());
			existente.get().setEndereco(usuarios.getEndereco());
			existente.get().setTelefone(usuarios.getTelefone());
		}
		return Optional.ofNullable(repository.save(existente.get()));
	}
	
	public Optional<Usuarios> alterarSenha(Usuarios usuarios) {
		Optional<Usuarios> existente = repository.findByEmail(usuarios.getEmail());
		if (existente.isEmpty()) {
			return Optional.empty();
		}
		else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	        String senhaEncoder = encoder.encode(usuarios.getSenha());
			existente.get().setSenha(senhaEncoder);
			return Optional.ofNullable(repository.save(existente.get()));
		}
		
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
	
	
	public Usuarios comprarProduto(Long idUsuario, Long idProduto, int qtdCompras, double valorDoacao) {
		Optional<Usuarios> usuarioExistente = repository.findById(idUsuario);
		Optional<Produtos> produtoExistente = repositoryProdutos.findById(idProduto);
			if(usuarioExistente.isPresent() && produtoExistente.isPresent()) {
				usuarioExistente.get().getMinhasCompras().add(produtoExistente.get());
				usuarioExistente.get().setValorCompra(produtoExistente.get().getPreco()*qtdCompras);
				usuarioExistente.get().setDoacao(valorDoacao);
				return repository.save(usuarioExistente.get());
			}
			return null;
	}
}
