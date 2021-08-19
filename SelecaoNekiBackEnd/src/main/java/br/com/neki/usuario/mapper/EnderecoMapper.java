package br.com.neki.usuario.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.neki.usuario.dto.EnderecoDTO;
import br.com.neki.usuario.entity.EnderecoEntity;

@Component
public class EnderecoMapper {
	

	@Autowired
	UsuarioMapper mapperUsuario;

	public EnderecoEntity dtoToEndereco(EnderecoDTO dto) {
		
		EnderecoEntity entity = new EnderecoEntity();		
		
		entity.setLogradouro(dto.getLogradouro());
		entity.setNumero(dto.getNumero());
		entity.setComplemento(dto.getComplemento());
		entity.setBairro(dto.getBairro());
		entity.setCep(dto.getCep());
		entity.setCidade(dto.getCidade());
		entity.setUf(dto.getUf());
		entity.setPais(dto.getPais());	
		entity.setDataCadastro(dto.getDataCadastro());
		entity.setDataAtualizacao(dto.getDataAtualizacao());
		entity.setUltimoAcesso(dto.getUltimoAcesso());

		
		return entity;
	}

	public EnderecoDTO enderecoToDto(EnderecoEntity entity) {

		EnderecoDTO dto = new EnderecoDTO();

		dto.setLogradouro(entity.getLogradouro());
		dto.setNumero(entity.getNumero());
		dto.setComplemento(entity.getComplemento());
		dto.setBairro(entity.getBairro());	
		dto.setCep(entity.getCep());
		dto.setCidade(entity.getCidade());
		dto.setUf(entity.getUf());
		dto.setPais(entity.getPais());
		dto.setDataCadastro(entity.getDataCadastro());
		dto.setDataAtualizacao(entity.getDataAtualizacao());
		dto.setUltimoAcesso(entity.getUltimoAcesso());
//		dto.setIdUsuario(mapperUsuario.usuarioToDto(entity.getIdUsuario()));

		return dto;
	}
}