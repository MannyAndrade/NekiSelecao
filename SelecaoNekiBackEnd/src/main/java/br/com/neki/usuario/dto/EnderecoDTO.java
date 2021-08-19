package br.com.neki.usuario.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class EnderecoDTO {

	
		private Long id;
		
		private String logradouro;
		
		private String numero;
		
		private String complemento;

		private String bairro;
		
		private String cep;

		private String cidade;
		
		private String uf;
		
		private String pais;
		
		private LocalDateTime dataCadastro;
		
		private LocalDateTime dataAtualizacao;
		
		private LocalDateTime ultimoAcesso;
					
		@JsonIgnore
		private UsuarioDTO idUsuario;
		
		
		
		@Override
		public String toString() {
			return "EnderecoDTO [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
					+ complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf
					+ ", pais=" + pais + ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao
					+ ", idUsuario=" + idUsuario + "]";
		}
		
		

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

		public UsuarioDTO getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(UsuarioDTO idUsuario) {
			this.idUsuario = idUsuario;
		}

}