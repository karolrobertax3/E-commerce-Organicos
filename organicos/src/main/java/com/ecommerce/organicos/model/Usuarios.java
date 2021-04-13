package com.ecommerce.organicos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotNull
	private String nomeRazaoSocial;
	
	@NotNull
	private String cpfCnpj;
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String endereco;
	
	@NotNull
	private String senha;
		
	private float valorCompra;
	
	private double doacao;
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "compras", 
	  joinColumns = @JoinColumn(name = "comprador_id"), 
	  inverseJoinColumns = @JoinColumn(name = "produto_id"))
	@JsonIgnoreProperties({"compradoPor", "qtdCompras"})
	private List<Produtos> minhasCompras = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "criadoPor")
	@JsonIgnoreProperties("criadoPor")
	private List<Produtos> meusProdutos = new ArrayList<>();

	public Usuarios() {
		
	}

	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public double getDoacao() {
		return doacao;
	}

	public void setDoacao(double doacao) {
		this.doacao = doacao;
	}

	public List<Produtos> getMinhasCompras() {
		return minhasCompras;
	}

	public void setMinhasCompras(List<Produtos> minhasCompras) {
		this.minhasCompras = minhasCompras;
	}

	public List<Produtos> getMeusProdutos() {
		return meusProdutos;
	}

	public void setMeusProdutos(List<Produtos> meusProdutos) {
		this.meusProdutos = meusProdutos;
	}

}
