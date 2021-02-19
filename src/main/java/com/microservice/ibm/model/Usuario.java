package com.microservice.ibm.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("usuario")
public class Usuario {
	
	@Id
	private Integer id;
	
	@NotNull
	@NotBlank(message = "O nome nao pode ser branco")
	private String nome;
	
	@NotNull
	@NotBlank(message = "O sexo nao pode ser branco")
	private Character sexo;
	
	@NotNull
	@NotBlank(message = "A idade nao pode ser branco")
	private Integer idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
	

}
