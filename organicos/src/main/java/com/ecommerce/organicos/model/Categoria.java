package com.ecommerce.organicos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;


	private boolean organico;
	private boolean frutas;
	private boolean hortalicas;
	private boolean legumes;
	
	@OneToMany(mappedBy = "categoriaDoProduto")
	public List<Produtos> produtos;
	

	public Categoria(boolean organico) {
		super();
		this.organico = organico;
	}
	
	public Categoria(boolean frutas, boolean hortalicas, boolean legumes) {
		super();
		this.frutas = frutas;
		this.hortalicas = hortalicas;
		this.legumes = legumes;
	}
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public boolean getOrganico() {
		return organico;
	}
	public void setOrganico(boolean organico) {
		this.organico = organico;
	}
	public boolean getFrutas() {
		return frutas;
	}
	public void setFrutas(boolean frutas) {
		this.frutas = frutas;
	}
	public boolean getHortalicas() {
		return hortalicas;
	}
	public void setHortalicas(boolean hortalicas) {
		this.hortalicas = hortalicas;
	}
	public boolean getLegumes() {
		return legumes;
	}
	public void setLegumes(boolean legumes) {
		this.legumes = legumes;
	}
	public List<Produtos> getProduto() {
		return produtos;
	}

	public void setProduto(List<Produtos> produto) {
		this.produtos = produto;
	}
}
