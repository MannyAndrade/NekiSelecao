package br.com.neki.usuario.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.neki.usuario.dto.EnderecoDTO;
import br.com.neki.usuario.entity.EnderecoEntity;
import br.com.neki.usuario.entity.UsuarioEntity;
import br.com.neki.usuario.exception.UsuarioNotFound;
import br.com.neki.usuario.mapper.EnderecoMapper;
import br.com.neki.usuario.mapper.UsuarioMapper;
import br.com.neki.usuario.repository.EnderecoRepository;
import br.com.neki.usuario.repository.UsuarioRepository;

@Service
public class EnderecoService {
	
	
	@Autowired
	UsuarioMapper usuarioMapper;
		
	@Autowired
	EnderecoMapper enderecoMapper; 
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;


//	@Value("${address.baseUrl}")
//	String baseUrl;
	

	public List<EnderecoDTO> findAll() {
		List<EnderecoEntity> list = new ArrayList<>();
		list.addAll(enderecoRepository.findAll());

		List<EnderecoDTO> listDTO = new ArrayList<>();

		for (EnderecoEntity endEnt : list) {
			listDTO.add(enderecoMapper.enderecoToDto(endEnt));
		}

		return listDTO;
	}


	public EnderecoDTO findById(Long id) throws UsuarioNotFound {
		Optional<EnderecoEntity> endReturn = enderecoRepository.findById(id);
		if (endReturn.isEmpty()) {
			throw new UsuarioNotFound("Id não encontrado!");
		}

		EnderecoDTO dto = enderecoMapper.enderecoToDto(endReturn.get());

		return dto;
	}

	
	public EnderecoDTO create(String cep, EnderecoDTO endDTO) throws HttpClientErrorException {
//        ViaCepDTO viaCep = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json", ViaCepDTO.class);
		
        EnderecoEntity endEnt = new EnderecoEntity();
        UsuarioEntity usuEnt = new UsuarioEntity();
        
//        endDTO.setIdUsuario(usuarioMapper.toDTO(usuEnt);
		
		endEnt.setLogradouro(endDTO.getLogradouro());		
		endEnt.setNumero(endDTO.getNumero());
		endEnt.setComplemento(endDTO.getComplemento());
       	endEnt.setBairro(endDTO.getBairro());
       	endEnt.setCep(endDTO.getCep());
       	endEnt.setCidade(endDTO.getCidade());
       	endEnt.setUf(endDTO.getUf());
       			
       	enderecoRepository.save(endEnt);
//		Long id = endDto.getId();
		endDTO.setDataCadastro(LocalDateTime.now());
		endEnt.setDataCadastro(endDTO.getDataCadastro());
		enderecoRepository.save(endEnt);
		EnderecoDTO dto = enderecoMapper.enderecoToDto(enderecoRepository.getById(endEnt.getId()));
		return dto;
	}
	
	
	public EnderecoDTO update(Long id, EnderecoDTO endDTO) throws UsuarioNotFound {
		findById(id);
		EnderecoDTO endDTONew = endDTO;

		if (endDTO.getLogradouro() != null) {
			enderecoRepository.findById(id).get().setLogradouro(endDTO.getLogradouro());
		}
		
		if(endDTO.getNumero() != null) {
			enderecoRepository.findById(id).get().setNumero(endDTO.getNumero());
        }        
		if(endDTO.getComplemento() != null) {
			enderecoRepository.findById(id).get().setComplemento(endDTO.getComplemento());
		}
        
		if(endDTONew.getBairro() != null) {
			enderecoRepository.findById(id).get().setBairro(endDTO.getBairro());
		}

        if(endDTONew.getCep() != null) {
        	enderecoRepository.findById(id).get().setCep(endDTO.getCep());
        }

        if(endDTONew.getCidade() != null) {
        	enderecoRepository.findById(id).get().setCidade(endDTO.getCidade());
        }

        if(endDTONew.getUf() != null) {
        	enderecoRepository.findById(id).get().setUf(endDTO.getUf());
        }
        if(endDTONew.getPais() != null) {
        	enderecoRepository.findById(id).get().setPais(endDTO.getPais());
        }

        enderecoRepository.findById(id).get().setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.findById(id).get().setDataAtualizacao(LocalDateTime.now());
        enderecoRepository.save(enderecoRepository.findById(id).get());
		return enderecoMapper.enderecoToDto(enderecoRepository.findById(id).get());
	}

	public void delete(Long id) throws UsuarioNotFound {
		findById(id);
		enderecoRepository.deleteById(id);
	}
}