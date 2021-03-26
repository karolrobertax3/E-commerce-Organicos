package com.ecommerce.organicos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 10, max = 50)
	private String nome;
	
	@NotNull
	@Size(min = 10, max = 60)
	private String razaoSocial;
	
	@NotNull
	@Size(min = 11, max = 14)
	private String cpf;
	
	@NotNull
	@Size(min = 14, max = 18)
	private String cnpj;
	
	@NotNull
	@Size(min = 10, max = 50)
	private String email;
	
	@NotNull
	@Size(min = 11, max = 15)
	private String telefone;
	
	@NotNull
	@Size(min = 8, max = 100)
	private String endereco;
	
	@NotNull
	@Size(min = 8)
	private String senha;
	
	
	@ManyToMany
	@JoinTable(
	  name = "compras_vendas", 
	  joinColumns = @JoinColumn(name = "usuario_id"), 
	  inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produtos> produtos = new ArrayList<>();

	public Usuarios() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	

}
