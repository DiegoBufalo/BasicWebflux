package com.microservice.ibm.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ibm.model.Usuario;


@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Integer>{
}
