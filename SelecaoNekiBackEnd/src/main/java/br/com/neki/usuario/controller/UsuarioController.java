package br.com.neki.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.usuario.dto.UsuarioDTO;
import br.com.neki.usuario.exception.UsuarioNotFound;
import br.com.neki.usuario.login.LoginForm;
import br.com.neki.usuario.securityConfiguration.TokenService;
import br.com.neki.usuario.service.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	UsuarioService usuarioService;
	
//	@Autowired
//	EnderecoService enderecoService;
	

	
	@PostMapping("/salvar")
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO dto){
		return new ResponseEntity<UsuarioDTO>(usuarioService.salvarUsuario(dto), HttpStatus.OK);
	}
	
	@GetMapping("/todosUsuarios")
	public ResponseEntity<List<UsuarioDTO>> verTodosUsuarios(){
		return new ResponseEntity<List<UsuarioDTO>>(usuarioService.verTodosUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/verUsuario/{codigo}")
	public ResponseEntity<UsuarioDTO> verUsuarios(@PathVariable String email) throws UsuarioNotFound{
		return new ResponseEntity<UsuarioDTO>(usuarioService.verUsuario(email), HttpStatus.OK);
	}
	
	@PutMapping("/atualizarUsuario")
	public ResponseEntity<String> atualizar(@RequestBody UsuarioDTO dto) throws UsuarioNotFound{
		return new ResponseEntity<String>(usuarioService.atualizarUsuario(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletarUsuarios(@RequestParam(name = "codigo") String codigo) throws UsuarioNotFound{
		return new ResponseEntity<String>(usuarioService.excluirUsuario(codigo), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioDTO> logar(@RequestBody LoginForm form) throws UsuarioNotFound{
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		UsuarioDTO dto = usuarioService.verUsuario(form.getEmail());
		try {
			Authentication authentication =authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			dto.setToken(token);		
			
			return new ResponseEntity<UsuarioDTO>(dto, HttpStatus.OK);
		}catch(AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
