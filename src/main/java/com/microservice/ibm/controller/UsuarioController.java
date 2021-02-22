package com.microservice.ibm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ibm.dto.UsuarioDTO;
import com.microservice.ibm.model.Usuario;
import com.microservice.ibm.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public Flux<Usuario> buscarUsuarios() {
		return usuarioService.retornarUsuarios();
	}
	
	@GetMapping(path = "{id}")
	public Mono<Usuario> buscarUsuarios(@PathVariable Integer id) {
		return usuarioService.retornarUsuario(id);
	}
	
	@GetMapping(value = "/filtro/{sexo}")
	public Flux<Usuario> buscarUsuariosPorSexo(@PathVariable Character sexo) {
		return usuarioService.retornarUsuarioPorSexo(sexo);
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Usuario> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuario) {
		return usuarioService.inserirUsuario(usuario);
	}
	
	@PutMapping(path = "{id}")
	public Mono<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuario) {
		return usuarioService.atualizarUsuario(id, usuario);
	}
	
	@DeleteMapping(path = "{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Mono<Void> deletarUsuario(@PathVariable Integer id){
		return usuarioService.deletarUsuario(id);
	}

}
