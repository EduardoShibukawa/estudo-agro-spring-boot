package com.github.eduardoshibukawa.totvsagro.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.github.eduardoshibukawa.totvsagro.dto.mapper.FazendaMapper;
import com.github.eduardoshibukawa.totvsagro.model.Endereco;
import com.github.eduardoshibukawa.totvsagro.model.Fazenda;

class FazendaMapperTest {

	@Test
	void quandoConverterModeloEmResponseDtoEntaoDeveTerDadosCorretos() {
		FazendaMapper mapper = new FazendaMapper();
		Fazenda modelo = new Fazenda(
				"Eduardo Farms", 
				"74.041.050/0001-53", 
				new Endereco("Maringá", "PR", "Av Maringá 1388"));
		
		FazendaResponseDto dto = mapper.toResponseDTO(modelo);
		
		assertEquals(modelo.getId(), dto.getId());
		assertEquals(modelo.getNome(), dto.getNome());
		assertEquals(modelo.getCnpj(), dto.getCnpj());
		assertNotNull(dto.getEndereco());
		assertEquals(modelo.getEndereco().getId(), dto.getEndereco().getId());
		assertEquals(modelo.getEndereco().getCidade(), dto.getEndereco().getCidade());
		assertEquals(modelo.getEndereco().getUf(), dto.getEndereco().getUf());
		assertEquals(modelo.getEndereco().getLogradouro(), dto.getEndereco().getLogradouro());
	}

	@Test
	void quandoConverterPostDtoEmModeloEntaoDeveTerDadosCorretos() {
		FazendaMapper mapper = new FazendaMapper();
		FazendaPostDto dto = new FazendaPostDto(
				"Eduardo Farms", 
				"74.041.050/0001-53", 
				new EnderecoPostDto("Maringá", "PR", "Av Maringá 1388"));
		
		Fazenda modelo = mapper.toModel(dto);
		
		assertEquals(dto.getNome(), modelo.getNome());
		assertEquals(dto.getCnpj(), modelo.getCnpj());
		assertNotNull(modelo.getEndereco());
		assertEquals(dto.getEndereco().getCidade(), modelo.getEndereco().getCidade());
		assertEquals(dto.getEndereco().getUf(), modelo.getEndereco().getUf());
		assertEquals(dto.getEndereco().getLogradouro(), modelo.getEndereco().getLogradouro());
	}	
	
	@Test
	void quandoConverterPutDtoEmModeloEntaoDeveTerDadosCorretos() {
		FazendaMapper mapper = new FazendaMapper();
		Fazenda modelo = new Fazenda(
				"Eduardo Farms", 
				"74.041.050/0001-53", 
				new Endereco("Maringá", "PR", "Av Maringá 1388"));		
		FazendaPutDto dto = new FazendaPutDto("Eduardo Farms");
		
		Fazenda modeloAtualizado = mapper.toModel(dto, modelo);
		
		assertEquals(modelo.getNome(), dto.getNome());
		assertEquals(modelo.getCnpj(), modeloAtualizado.getCnpj());
		assertNotNull(modeloAtualizado.getEndereco());
		assertEquals(modelo.getEndereco().getCidade(), modeloAtualizado.getEndereco().getCidade());
		assertEquals(modelo.getEndereco().getUf(), modeloAtualizado.getEndereco().getUf());
		assertEquals(modelo.getEndereco().getLogradouro(), modeloAtualizado.getEndereco().getLogradouro());
	}	
}
