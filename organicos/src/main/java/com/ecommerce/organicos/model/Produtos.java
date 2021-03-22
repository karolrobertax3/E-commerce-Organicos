package com.ecommerce.organicos.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer idProduto;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataSafra;
	
	@NotNull
	@Size(min = 5, max = 30)
	private String nome;
	
	@Size(max = 250)
	private String descricao;
	
	@Column(name="Preço", columnDefinition="Decimal(5,2) default '0.00'")
	private float preco;

	
	public Produtos() {

	}
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
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

}
