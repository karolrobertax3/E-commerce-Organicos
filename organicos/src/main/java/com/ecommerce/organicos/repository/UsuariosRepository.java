package com.ecommerce.organicos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.organicos.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	
	public List<Usuarios> findAllByNomeContainingIgnoreCase (String nome);
	
	public List<Usuarios> findAllByEnderecoContainingIgnoreCase (String endereco);
	
	public Optional<Usuarios> findByEmail(String email);
		
}
