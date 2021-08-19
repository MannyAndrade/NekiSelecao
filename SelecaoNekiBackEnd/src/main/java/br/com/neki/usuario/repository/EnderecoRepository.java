package br.com.neki.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.usuario.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long>{

//    EnderecoEntity findByIdUsuarioId(Long id);

}