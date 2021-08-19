package br.com.neki.usuario.usuario.util;

public class GeradorDeCodigos {
	
	
	public String gerarIdentificador() {
		String codigo = "";
		char letra;
		int numero;
		
		for(int i = 0; i < 3; i++) {
			codigo += letra =(char) Math.round(26 * Math.random() + 64);
			codigo += numero =(int) Math.round(9 * Math.random());
		}
		
		return codigo;
	}

}
