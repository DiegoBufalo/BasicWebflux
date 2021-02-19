package com.microservice.ibm.service;


import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.microservice.ibm.model.Usuario;
import com.microservice.ibm.repository.UsuarioRepository;
import com.microservice.ibm.util.UsuarioCreator;

import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.scheduler.Schedulers;

@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	@Mock
	private UsuarioRepository usuarioRepositoryMock;
	
	private final Usuario usuario = UsuarioCreator.criaUsuarioValido();
	
	@BeforeAll
	public static void blockHoundSetup() {
		BlockHound.install();
	}

	@Test
    public void blockHoundWorks() {
        try {
            FutureTask<?> task = new FutureTask<>(() -> {
                Thread.sleep(0);
                return "";
            });
            Schedulers.parallel().schedule(task);

            task.get(10, TimeUnit.SECONDS);
            Assertions.fail("should fail");
        } catch (Exception e) {
        	 Assertions.assertTrue(e.getCause() instanceof BlockingOperationError);
        }
    }
}
