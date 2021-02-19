package com.microservice.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.microservice.ibm.dto.UsuarioDTO;
import com.microservice.ibm.model.Usuario;
import com.microservice.ibm.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Flux<Usuario> retornarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Mono<Usuario> retornarUsuario(Integer id){
		return usuarioRepository.findById(id)
				.switchIfEmpty(monoResponseStatusNotFoundException());
	}
	
	public Mono<Usuario> inserirUsuario(UsuarioDTO usuario){
		Usuario usuarioConvertido = usuario.toUsuario(usuario);
		return usuarioRepository.save(usuarioConvertido);
	}
	
	public Mono<Usuario> atualizarUsuario(Integer id, UsuarioDTO usuario) {
		Usuario usuarioConvertido = usuario.toUsuario(usuario);
		usuarioConvertido.setId(id);
		return usuarioRepository.save(usuarioConvertido);
	}
	
	public Mono<Void> deletarUsuario(Integer id) {
		return usuarioRepository.deleteById(id);
	}
		
	public <T> Mono<T> monoResponseStatusNotFoundException(){
		return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario nao encontrado"));

	
	}

	
	
}
