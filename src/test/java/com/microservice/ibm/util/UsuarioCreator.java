package com.microservice.ibm.util;

import com.microservice.ibm.model.Usuario;

public class UsuarioCreator {
	
	public static Usuario criaUsuarioParaSalvar() {
		Usuario usuario = new Usuario();
		usuario.setIdade(22);
		usuario.setNome("Usuario");
		usuario.setSexo('M');
		
		return usuario;
	}
	
	public static Usuario criaUsuarioValido() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setIdade(22);
		usuario.setNome("Usuario");
		usuario.setSexo('M');
		
		return usuario;
	}
	
	public static Usuario criaUsuarioParaAtualizar() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setIdade(22);
		usuario.setNome("Usuario 2");
		usuario.setSexo('M');
		
		return usuario;
	}

}
