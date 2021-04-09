package com.ecommerce.organicos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.ecommerce.organicos.model.util.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataSafra;
	
	@NotNull
	private String titulo;
	
	private String descricao;
	
	@NotNull
	private boolean organico;
	
	@NotNull
	private int qtdEstoque;
	
	private int qtdCompras;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	
	@Column(name="Preço", columnDefinition="Decimal(5,2)")
	private float preco;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "criador")
	@JsonIgnoreProperties({"meusProdutos", "minhasCompras"})
	private Usuarios criadoPor;
	
	
	@ManyToMany(mappedBy = "minhasCompras", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"meusProdutos", "minhasCompras"})
	private List<Usuarios> compradoPor = new ArrayList<>();
	
	
	public Produtos() {

	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Date getDataSafra() {
		return dataSafra;
	}
	public void setDataSafra(Date dataSafra) {
		this.dataSafra = dataSafra;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public boolean getOrganico() {
		return organico;
	}

	public void setOrganico(boolean organico) {
		this.organico = organico;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuarios getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Usuarios criadoPor) {
		this.criadoPor = criadoPor;
	}

	public List<Usuarios> getCompradoPor() {
		return compradoPor;
	}

	public void setCompradoPor(List<Usuarios> compradoPor) {
		this.compradoPor = compradoPor;
	}
	public int getQtdCompras() {
		return qtdCompras;
	}

	public void setQtdCompras(int qtdCompras) {
		this.qtdCompras = qtdCompras;
	}	
}
