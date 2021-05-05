package com.ecommerce.organicos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import com.ecommerce.organicos.model.Produtos;
import com.ecommerce.organicos.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	
	public Optional<Usuarios> findByEmail(String email);
	
	
	@Query(value = "SELECT * FROM usuarios INNER JOIN produtos"
			+ " ON criador=id_usuario"
			+ " WHERE usuarios.nome_razao_social LIKE %:nome%", 
			nativeQuery = true)
	public List<Usuarios> findUsuariosByNomeRazaoSocial(@Param("nome")String nome);
	
	@Query(value = "SELECT * from usuarios inner join produtos on criador=id_usuario"
			+ " where usuarios.endereco like %:regiao%", 
			nativeQuery = true)
	public List<Usuarios> findUsuariosByEndereco (@Param("regiao")String regiao);
	
}
