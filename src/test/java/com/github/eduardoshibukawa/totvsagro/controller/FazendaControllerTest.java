package com.github.eduardoshibukawa.totvsagro.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.eduardoshibukawa.totvsagro.dto.FazendaPostDto;
import com.github.eduardoshibukawa.totvsagro.service.FazendaService;

@SpringBootTest
class FazendaControllerTest {
	
	@Mock
	private FazendaService fazendaServiceMock;
	
	@InjectMocks
	private FazendaController controller;

	@Test
	void quandoRealizarPostEntaoDeveUtilizarService() {		
		when(fazendaServiceMock.salvar(any())).thenReturn(any());
		
		FazendaPostDto dto = new FazendaPostDto();
		
		controller.post(dto);
				
		verify(fazendaServiceMock).salvar(dto);
	}

	@Test
	void quandoRealizarPostComSucessoEntaoDeveTerResposta201() {		
		when(fazendaServiceMock.salvar(any())).thenReturn(1L);
		
		FazendaPostDto dto = new FazendaPostDto();
		
		ResponseEntity<Long> resposta = controller.post(dto);
		 		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Test
	void quandoRealizarPostComSucessoEntaoUriDeveEstarCorreta() throws URISyntaxException {		
		when(fazendaServiceMock.salvar(any())).thenReturn(1L);
		
		FazendaPostDto dto = new FazendaPostDto();
		
		ResponseEntity<Long> resposta = controller.post(dto);
		
		URI expectedURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(1)
				.toUri();
		
		assertEquals(expectedURI, resposta.getHeaders().getLocation());
	}	
}
