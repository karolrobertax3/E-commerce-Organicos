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
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoriaDoProduto;
	
	
	@Column(name="Preço", columnDefinition="Decimal(5,2)")
	private float preco;
	
	
	@ManyToMany(mappedBy = "produtos")
	private List<Usuarios> usuarios = new ArrayList<>();

	

	
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

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean getOrganico() {
		return organico;
	}

	public void setOrganico(boolean organico) {
		this.organico = organico;
	}

	public CategoriaEnum getCategoriaDoProduto() {
		return categoriaDoProduto;
	}

	public void setCategoriaDoProduto(CategoriaEnum categoriaDoProduto) {
		this.categoriaDoProduto = categoriaDoProduto;
	}

	/*public Categoria getCategoriaDoProduto() {
		return categoriaDoProduto;
	}

	public void setCategoriaDoProduto(Categoria categoriaDoProduto) {
		this.categoriaDoProduto = categoriaDoProduto;
	}*/

	

}
