package com.github.eduardoshibukawa.totvsagro.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.eduardoshibukawa.totvsagro.configuration.AbstractIntegrationTest;
import com.github.eduardoshibukawa.totvsagro.dto.EnderecoPostDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaPostDto;

@SpringBootTest
class FazendaControllerIntegrationTest extends AbstractIntegrationTest {
		
	@Autowired
	private FazendaController controller;
    
	@Test
	@Transactional
	void quandoRealizarPostComSucessoEntaoDeveTerResposta201() {		
		FazendaPostDto dto = new FazendaPostDto(
				"Eduardo Farms", 
				"74.041.050/0001-53", 
				new EnderecoPostDto("Maringá", "PR", "Av Maringá 1388"));		
		
		ResponseEntity<Long> resposta = controller.post(dto);
		 		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Test
	@Transactional
	void quandoRealizarPostComSucessoEntaoUriDeveEstarCorreta() throws URISyntaxException {		
		FazendaPostDto dto = new FazendaPostDto(
				"Eduardo Farms", 
				"74.041.050/0001-53", 
				new EnderecoPostDto("Maringá", "PR", "Av Maringá 1388"));		
		
		ResponseEntity<Long> resposta = controller.post(dto);
		
		URI expectedURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(1)
				.toUri();
		
		assertEquals(expectedURI, resposta.getHeaders().getLocation());
	}
}
