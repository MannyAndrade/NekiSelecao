package br.com.neki.usuario.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.neki.usuario.usuario.util.GeradorDeCodigos;



@Entity //@Table(name="Usuario")
public class UsuarioEntity  implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@NotNull
	private String nome;
	private String codigoUsuario = new GeradorDeCodigos().gerarIdentificador();
//	@NotNull
	private LocalDate dataNascimento;
//	@NotNull
	private String cpf;
//	@NotNull
	private String linguagem1;	
//	@NotNull
	private String linguagem2;	
//	@NotNull
	private String linguagem3;	
//	@NotNull
	private String ingles;	
//	@NotNull
	private String telefone1;	
	private String telefone2;		
	private LocalDateTime dataCadastro;	
	private LocalDateTime dataAtualizacao;
	private LocalDateTime ultimoAcesso;
//	@NotNull
    private String email;
	private String senha;	
	public boolean usuarioAtivo = true;		
	private Character tipoUsuario; //U: Usuario | F: Funcionário
	@ManyToMany(fetch = FetchType.EAGER)
	private List<PerfilEntity> perfis = new ArrayList<PerfilEntity>();
//	@NotNull
	@OneToOne(cascade = CascadeType.PERSIST)
	private EnderecoEntity idEndereco;	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	public String getLinguagem1() {
		return linguagem1;
	}
	public void setLinguagem1(String linguagem1) {
		this.linguagem1 = linguagem1;
	}
	public String getLinguagem2() {
		return linguagem2;
	}
	public void setLinguagem2(String linguagem2) {
		this.linguagem2 = linguagem2;
	}
	public String getLinguagem3() {
		return linguagem3;
	}
	public void setLinguagem3(String linguagem3) {
		this.linguagem3 = linguagem3;
	}
	public String getIngles() {
		return ingles;
	}
	public void setIngles(String ingles) {
		this.ingles = ingles;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public LocalDateTime getUltimoAcesso() {
		return ultimoAcesso;
	}
	public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public boolean isUsuarioAtivo() {
		return usuarioAtivo;
	}
	public void setUsuarioAtivo(boolean usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}	
	public List<PerfilEntity> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<PerfilEntity> perfis) {
		this.perfis = perfis;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public EnderecoEntity getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(EnderecoEntity idEndereco) {
		this.idEndereco = idEndereco;
	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}


	public Character getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Character tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.perfis;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}	
}

