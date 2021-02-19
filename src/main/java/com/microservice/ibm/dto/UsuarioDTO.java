package com.microservice.ibm.dto;

import com.microservice.ibm.model.Usuario;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UsuarioDTO {
	
	public String nome;
	
	public Integer idade;
	
	public Character sexo;
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Integer getIdade() {
		return idade;
	}



	public void setIdade(Integer idade) {
		this.idade = idade;
	}



	public Character getSexo() {
		return sexo;
	}



	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}



	public Usuario toUsuario(UsuarioDTO usuario) {
		Usuario usuarioConvertido = new Usuario();
			usuarioConvertido.setIdade(usuario.getIdade());
			usuarioConvertido.setNome(usuario.getNome());
			usuarioConvertido.setSexo(usuario.getSexo());
		return usuarioConvertido;
	}

}
