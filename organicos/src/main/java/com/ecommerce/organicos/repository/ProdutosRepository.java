package com.ecommerce.organicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.organicos.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

}
