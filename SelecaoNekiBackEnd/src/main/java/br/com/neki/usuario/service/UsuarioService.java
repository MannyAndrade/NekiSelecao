package br.com.neki.usuario.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.neki.usuario.dto.UsuarioDTO;
import br.com.neki.usuario.entity.UsuarioEntity;
import br.com.neki.usuario.exception.UsuarioNotFound;
import br.com.neki.usuario.mapper.UsuarioMapper;
import br.com.neki.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired 
	UsuarioMapper usuarioMapper;
	
	
	public UsuarioDTO /*String*/ salvarUsuario(UsuarioDTO dto) {
		
		UsuarioEntity usuEnt = new UsuarioEntity();			
		usuEnt = usuarioMapper.dtoToUsuario(dto);		
		usuEnt.setDataCadastro(LocalDateTime.now());			
		
		return usuarioMapper.usuarioToDto(usuarioRepository.save(usuEnt));
		
//		dto.setDataCadastro(LocalDateTime.now());
//		usuarioRepository.save(usuarioMapper.dtoToUsuario(dto));
//		return "Usuário salvo com sucesso";
	}
	
	
	public List<UsuarioDTO> verTodosUsuarios(){
		return usuarioMapper.listDtoToUsuario(usuarioRepository.findAll()) ;	
	}
	
	
	public UsuarioDTO verUsuario(String email) throws UsuarioNotFound{
		try {
			UsuarioEntity user = usuarioRepository.findByEmail(email).get();
			user.setUltimoAcesso(LocalDateTime.now());
			usuarioRepository.saveAndFlush(user);
			return usuarioMapper.usuarioToDto(user);		
		}catch(NullPointerException erro) {
			throw new UsuarioNotFound("Usuário não encontrado");
		}
	}
	
	public String atualizarUsuario(UsuarioDTO dto) throws UsuarioNotFound {
	UsuarioEntity usuario = null;
	try {
		usuario = usuarioRepository.getByCodigo(dto.getCodigoUsuario());		
	}catch(NullPointerException erro) {
		throw new UsuarioNotFound("Usuário não encontrado");
	}
		if(dto.getNome() != null) {
			usuario.setNome(dto.getNome());
		}		
		if(dto.isUsuarioAtivo()) {
			usuario.setUsuarioAtivo(true);
		}
		if(dto.getDataNascimento() != null) {
			usuario.setDataNascimento(dto.getDataNascimento());
		}
		if(dto.getCpf() != null) {
			usuario.setCpf(dto.getCpf());
		}
		if(dto.getLinguagem1() != null) {
			usuario.setLinguagem1(dto.getLinguagem1());
		}
		if(dto.getLinguagem2() != null) {
			usuario.setLinguagem2(dto.getLinguagem2());
		}
		if(dto.getLinguagem3() != null) {
			usuario.setLinguagem3(dto.getLinguagem3());
		}
		if(dto.getIngles() != null) {
			usuario.setIngles(dto.getIngles());
		}		
		if(dto.getTelefone1() != null) {
			usuario.setTelefone1(dto.getTelefone1());
		}
		if(dto.getTelefone2() != null) {
			usuario.setTelefone2(dto.getTelefone2());
		}
		if(dto.getEmail() != null) {
			usuario.setEmail(dto.getEmail());
		}
		if(dto.getSenha() != null) {
			usuario.setSenha(dto.getSenha());
		}		
				
		usuario.setDataAtualizacao(LocalDateTime.now());
		
		usuarioRepository.saveAndFlush(usuario);
		return "Usuário atualizado com sucesso!";
	}
	
	public String excluirUsuario(String codigo) throws UsuarioNotFound {
		UsuarioEntity usuario = null;
		try {
			usuario = usuarioRepository.getByCodigo(codigo);		
		}catch(NullPointerException erro) {
			throw new UsuarioNotFound("Usuário não encontrado");
		}
		
		usuario.setDataAtualizacao(LocalDateTime.now());
		usuario.setUsuarioAtivo(false);
		usuarioRepository.saveAndFlush(usuario);
		return "Usuário inativado com sucesso";
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<UsuarioEntity> usuario = usuarioRepository.findByEmail(email);
		if(usuario.isPresent()) {
			
			return usuario.get();
			
		}
		
		throw new UsernameNotFoundException("Usuário não encontrado");
	}	
}

