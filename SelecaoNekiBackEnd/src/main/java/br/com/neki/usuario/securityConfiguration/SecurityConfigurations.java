package br.com.neki.usuario.securityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.neki.usuario.repository.UsuarioRepository;
import br.com.neki.usuario.service.UsuarioService;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

//	private static final String[] AUTH_WHITELIST = {"/usuario/salvar","/produto/pegarProdutos","/produto/pegarProduto**",
//			"/categoria/pegarCategoria**","/categoria/pegarCategorias","/categoria/salvar"};
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	//configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}
	// configuracoes de autorizacao
	///usuario/salvar
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/categoria/pegarCategorias").permitAll()
		.antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
		.antMatchers(HttpMethod.POST, "/usuario/login").permitAll()
		.anyRequest().authenticated().and().csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);

	}
	//  configuracoes de recursos estaticos
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
}

