package br.com.neki.usuario.exceptionCare;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.neki.usuario.exception.UsuarioNotFound;



@RestControllerAdvice
public class ExceptionCare {
	
//	@ExceptionHandler(ProdutoNotFound.class)
//	public ResponseEntity<String> erroProdutoNotFound(ProdutoNotFound erro){
//		return  ResponseEntity.notFound().header("x-msg-erro", erro.getMessage()).build();
//	}
	
//	@ExceptionHandler(CategoriaNotFound.class)
//	public ResponseEntity<String> erroCategoriaNotFound(CategoriaNotFound erro){
//		return ResponseEntity.notFound().header("x-msg-erro", erro.getMessage()).build();
//	}
	
	@ExceptionHandler(UsuarioNotFound.class)
		public ResponseEntity<String> funcionarioNotFound(UsuarioNotFound erro) {
		return ResponseEntity. notFound().header("x-msg-erro", erro.getMessage()).build();
	}

}
