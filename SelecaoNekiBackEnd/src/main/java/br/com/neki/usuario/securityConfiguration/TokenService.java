package br.com.neki.usuario.securityConfiguration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.neki.usuario.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${pmt.jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.secret.usuario}")
	private String secretUsuario;

	public String gerarToken(Authentication authentication) {
	
		UsuarioEntity logado = (UsuarioEntity) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder().setIssuer("API portalEmpreendedorUsuario")
				.setSubject(logado.getCodigoUsuario())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secretUsuario)
				.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			
			Jwts.parser().setSigningKey(this.secretUsuario).parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public String getCodigoUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secretUsuario).parseClaimsJws(token).getBody();
		return 	claims.getSubject();
	}

}

