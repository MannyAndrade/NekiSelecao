package br.com.neki.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.neki.usuario.dto.EnderecoDTO;
import br.com.neki.usuario.exception.UsuarioNotFound;
import br.com.neki.usuario.service.EnderecoService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired 
    EnderecoService service;
    

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll () {
        return ResponseEntity.ok().header("Method: ", "Find All").body(service.findAll());
    }
    
    
    @GetMapping("/{id}")
    public EnderecoDTO findById(@PathVariable Long id) throws UsuarioNotFound{
    	
    	return    service.findById(id);
    }
    

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO endDTO) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Method: ", "Create");
        EnderecoDTO body = service.create(endDTO.getCep(), endDTO);

        return new ResponseEntity<EnderecoDTO>(body,headers,HttpStatus.CREATED);
    }
    
    
    @PutMapping("/update/{id}")
	public EnderecoDTO update(@PathVariable Long id, @RequestBody EnderecoDTO endDTO) throws NotFoundException, UsuarioNotFound {
		
    	
    	
//    	id = empresaEntity.getEnderecoEmpresaId 
    	
    	return service.update(id, endDTO);
	}
    

    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws UsuarioNotFound{
        service.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}