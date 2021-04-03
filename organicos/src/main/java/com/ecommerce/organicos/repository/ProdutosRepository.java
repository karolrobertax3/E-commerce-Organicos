package com.ecommerce.organicos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.organicos.model.CategoriaEnum;
import com.ecommerce.organicos.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
	public List<Produtos> findAllByOrganico (boolean organico);
	public List<Produtos> findByDataSafra (Date data);
	public List<Produtos> findByCategoriaDoProdutoContainingIgnoreCase(CategoriaEnum categoriaDoProduto);
	public List<Produtos> findAllByNomeContainingIgnoreCase(String nome);

}
