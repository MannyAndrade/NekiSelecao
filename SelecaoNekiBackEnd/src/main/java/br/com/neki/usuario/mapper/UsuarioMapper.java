package br.com.neki.usuario.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.neki.usuario.dto.UsuarioDTO;
import br.com.neki.usuario.entity.UsuarioEntity;

@Component
public class UsuarioMapper {
	
	@Autowired
	EnderecoMapper mapperEndereco;
	
	
	public UsuarioEntity dtoToUsuario(UsuarioDTO dto) {			
		
		UsuarioEntity usuario = new UsuarioEntity();		

		usuario.setNome(dto.getNome());
		usuario.setDataNascimento(dto.getDataNascimento());
		usuario.setCpf(dto.getCpf());
		usuario.setLinguagem1(dto.getLinguagem1());
		usuario.setLinguagem2(dto.getLinguagem2());
		usuario.setLinguagem3(dto.getLinguagem3());
		usuario.setIngles(dto.getIngles());				
		usuario.setTelefone1(dto.getTelefone1());
		usuario.setTelefone2(dto.getTelefone2());
		usuario.setDataCadastro(dto.getDataCadastro());
		usuario.setDataAtualizacao(dto.getDataAtualizacao());
		usuario.setUltimoAcesso(dto.getUltimoAcesso());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));
//		usuario.setUsuarioAtivo(dto.isUsuarioAtivo());		
		usuario.setTipoUsuario(dto.getTipoUsuario());
		usuario.setIdEndereco(mapperEndereco.dtoToEndereco(dto.getIdEndereco()));

		return usuario;
	}

	public UsuarioDTO usuarioToDto(UsuarioEntity usuario) {
		
		UsuarioDTO dto = new UsuarioDTO();
//		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setCodigoUsuario(usuario.getCodigoUsuario());
		dto.setDataNascimento(usuario.getDataNascimento());		
		dto.setCpf(usuario.getCpf());
		dto.setLinguagem1(usuario.getLinguagem1());
		dto.setLinguagem2(usuario.getLinguagem2());
		dto.setLinguagem3(usuario.getLinguagem3());
		dto.setIngles(usuario.getIngles());				
		dto.setTelefone1(usuario.getTelefone1());
		dto.setTelefone2(usuario.getTelefone2());
		dto.setDataCadastro(usuario.getDataCadastro());
		dto.setDataAtualizacao(usuario.getDataAtualizacao());
		dto.setUltimoAcesso(usuario.getUltimoAcesso());
		dto.setEmail(usuario.getEmail());
//		dto.setSenha(usuario.getSenha()); 
		dto.setUsuarioAtivo(usuario.isUsuarioAtivo());		
		dto.setTipoUsuario(usuario.getTipoUsuario());
		dto.setIdEndereco(mapperEndereco.enderecoToDto(usuario.getIdEndereco()));
			
		return dto;
	}
	
public List<UsuarioDTO> listDtoToUsuario(List<UsuarioEntity> usuarios) {
		
		List<UsuarioDTO> dto = new ArrayList<UsuarioDTO>();
		
		for(UsuarioEntity usuario : usuarios) {
			
			dto.add(usuarioToDto(usuario));
		}

		return dto;		
	}	
}