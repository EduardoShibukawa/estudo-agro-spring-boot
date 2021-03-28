package com.github.eduardoshibukawa.totvsagro.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.eduardoshibukawa.totvsagro.dto.FazendaPostDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaPutDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaResponseDto;
import com.github.eduardoshibukawa.totvsagro.model.Fazenda;

@Component
public class FazendaMapper {
	
	final private ModelMapper mapper = new ModelMapper();
	
	public FazendaMapper() {}
	
	public FazendaResponseDto toResponseDTO(Fazenda fazenda) {
		return mapper.map(fazenda, FazendaResponseDto.class);
	}

	public Fazenda toModel(FazendaPostDto dto) {
		return mapper.map(dto,Fazenda.class);
	};
	
	public Fazenda toModel(FazendaPutDto dto, Fazenda fazenda) {
		mapper.map(dto, fazenda);
		
		return fazenda;
	}
}
