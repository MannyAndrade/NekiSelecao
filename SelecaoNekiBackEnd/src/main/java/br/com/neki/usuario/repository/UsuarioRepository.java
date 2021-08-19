package br.com.neki.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.neki.usuario.entity.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	@Query("FROM UsuarioEntity WHERE codigoUsuario LIKE ?1 ")
	UsuarioEntity getByCodigo(@Param("codigoUsuario")String codigo);
	
	Optional<UsuarioEntity> findByEmail(String email);
}



