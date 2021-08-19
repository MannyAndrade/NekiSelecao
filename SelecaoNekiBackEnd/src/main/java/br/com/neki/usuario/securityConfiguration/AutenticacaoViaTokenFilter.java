package br.com.neki.usuario.securityConfiguration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.neki.usuario.entity.UsuarioEntity;
import br.com.neki.usuario.repository.UsuarioRepository;


public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService,UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticarCliente(token);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		String codigoUsuario = tokenService.getCodigoUsuario(token);

		UsuarioEntity usuario = usuarioRepository.getByCodigo(codigoUsuario);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.split(" ")[2];
	}

}

