package br.com.neki.usuario.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Endereco")
public class EnderecoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull
	private String logradouro;
	
//	@NotNull
	private String numero;
	
	private String complemento;
	
//	@NotNull
	private String bairro;
	
//	@NotNull
	private String cep;
	
//	@NotNull
	private String cidade;
	
//	@NotNull
	private String uf;
	
//	@NotNull
	private String pais;
	
	private LocalDateTime dataCadastro;
	
	private LocalDateTime dataAtualizacao;
	
	private LocalDateTime ultimoAcesso;

		
//	@JsonIgnore
//	@JsonBackReference
//	@NotNull
	@OneToOne 
    private UsuarioEntity idUsuario;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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

	public UsuarioEntity getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UsuarioEntity idUsuario) {
		this.idUsuario = idUsuario;
	}

}
