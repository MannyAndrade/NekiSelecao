package br.com.neki.usuario.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDTO {


	private String nome;
	private String codigoUsuario;
	private LocalDate dataNascimento;
	private String cpf;
	private String linguagem1;	
	private String linguagem2;	
	private String linguagem3;	
	private String ingles;			
	private String telefone1;	
	private String telefone2;		
	private LocalDateTime dataCadastro;	
	private LocalDateTime dataAtualizacao;
	private LocalDateTime ultimoAcesso;
	private String email;
	private String senha;
	public boolean usuarioAtivo = true;	
	private String token;
	private String tipoToken = "Bearer";
	private Character tipoUsuario;
	private EnderecoDTO idEndereco;

	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
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
	public boolean isUsuarioAtivo() {
		return usuarioAtivo;
	}
	public void setUsuarioAtivo(boolean usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
//	public String getTipoToken() {
//		return tipoToken;
//	}
//	public void setTipoToken(String tipoToken) {
//		this.tipoToken = tipoToken;
//	}

	public Character getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Character tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public EnderecoDTO getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(EnderecoDTO idEndereco) {
		this.idEndereco = idEndereco;
	}
}
