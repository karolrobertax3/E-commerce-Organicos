package com.ecommerce.organicos.model;

public class UsuarioLogin {
	
	private Long idUsuario;
	private String nome;
	private String email;
	private String senha;
	private String foto;
	private String fotoLoja;
	private String token;
	
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFotoLoja() {
		return fotoLoja;
	}
	public void setFotoLoja(String fotoLoja) {
		this.fotoLoja = fotoLoja;
	}
	
}
