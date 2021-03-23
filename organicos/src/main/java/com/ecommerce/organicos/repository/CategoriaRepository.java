package com.ecommerce.organicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.organicos.model.Categoria;
import com.ecommerce.organicos.model.Produtos;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Produtos> findAllByOrganico (String categoria);
}
