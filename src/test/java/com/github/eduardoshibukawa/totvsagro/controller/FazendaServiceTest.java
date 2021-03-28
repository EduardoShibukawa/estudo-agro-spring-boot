package com.github.eduardoshibukawa.totvsagro.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.eduardoshibukawa.totvsagro.dto.EnderecoPostDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaPostDto;
import com.github.eduardoshibukawa.totvsagro.dto.mapper.FazendaMapper;
import com.github.eduardoshibukawa.totvsagro.model.Fazenda;
import com.github.eduardoshibukawa.totvsagro.repositories.FazendaRepository;
import com.github.eduardoshibukawa.totvsagro.service.FazendaService;


@ExtendWith(MockitoExtension.class)
class FazendaServiceTest {

	@Mock
	private FazendaRepository fazendaRepositoryMock;
	
	private FazendaMapper mapper = new FazendaMapper();
	
	@Test
	void quandoRealizarPostEntaoDeveUtilizarService() {
		FazendaService service = new FazendaService(fazendaRepositoryMock, mapper);
		Fazenda fazendaMock = mock(Fazenda.class);
		FazendaPostDto dto = new FazendaPostDto(
				"Eduardo Farms", 
				"74.041.050/0001-53", 
				new EnderecoPostDto("Maringá", "PR", "Av Maringá 1388"));		
		
		when(fazendaMock.getId()).thenReturn(1L);
		when(fazendaRepositoryMock.save(any())).thenReturn(fazendaMock);

		service.salvar(dto);
				
		verify(fazendaRepositoryMock).save(any());
	}	
}
