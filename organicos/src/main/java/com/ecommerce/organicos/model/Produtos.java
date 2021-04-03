package com.ecommerce.organicos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.validation.constraints.Size;

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
	@Size(min = 5, max = 30)
	private String nome;
	
	@Size(max = 250)
	private String descricao;
	
	@NotNull
	private boolean organico;
	
	private int qtdEstoque;
	
	private int qtdCompras;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoriaDoProduto;
	
	
	@Column(name="Preço", columnDefinition="Decimal(5,2)")
	private float preco;
	
	/*@ManyToOne
	@JoinColumn(name = "criador")
	@JsonIgnoreProperties({"meusProdutos", "minhasCompras"})
	private Usuarios criadoPor;*/
	
	/*@ManyToMany(mappedBy = "minhasCompras")
	@JsonIgnoreProperties("meusProdutos")
	private List<Usuarios> compradoPor = new ArrayList<>();*/
	
	/*@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoriaDoProduto;*/
	

	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public int getQtdCompras() {
		return qtdCompras;
	}

	public void setQtdCompras(int qtdCompras) {
		this.qtdCompras = qtdCompras;
	}

	public CategoriaEnum getCategoriaDoProduto() {
		return categoriaDoProduto;
	}

	public void setCategoriaDoProduto(CategoriaEnum categoriaDoProduto) {
		this.categoriaDoProduto = categoriaDoProduto;
	}

	/*public Usuarios getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Usuarios criadoPor) {
		this.criadoPor = criadoPor;
	}*/

	/*public List<Usuarios> getCompradoPor() {
		return compradoPor;
	}

	public void setCompradoPor(List<Usuarios> compradoPor) {
		this.compradoPor = compradoPor;
	}*/

	/*public Categoria getCategoriaDoProduto() {
		return categoriaDoProduto;
	}
	public void setCategoriaDoProduto(Categoria categoriaDoProduto) {
		this.categoriaDoProduto = categoriaDoProduto;
	}*/

}