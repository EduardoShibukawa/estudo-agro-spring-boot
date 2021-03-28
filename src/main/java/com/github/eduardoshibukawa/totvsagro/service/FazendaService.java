package com.github.eduardoshibukawa.totvsagro.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.github.eduardoshibukawa.totvsagro.dto.FazendaPostDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaPutDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaResponseDto;
import com.github.eduardoshibukawa.totvsagro.dto.mapper.FazendaMapper;
import com.github.eduardoshibukawa.totvsagro.model.Fazenda;
import com.github.eduardoshibukawa.totvsagro.repositories.FazendaRepository;

import javassist.NotFoundException;

@Service
public class FazendaService {

    final private FazendaRepository repository;
    
    final private FazendaMapper mapper;
    
    @Autowired
    public FazendaService(FazendaRepository repository, FazendaMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	public Long salvar(FazendaPostDto dto) {
        Objects.requireNonNull(dto.getEndereco(), "Endereço deve ser informado!");
        
        final Fazenda fazenda = mapper.toModel(dto);
        
        return repository.save(fazenda).getId();
    }

    public void atualizar(Long id, FazendaPutDto dto) throws NotFoundException {
        Fazenda fazenda = mapper.toModel(dto, this.buscarFazendaById(id));

        repository.save(fazenda);
    }
    
    public void deletar(Long id) throws NotFoundException {
        repository.delete(buscarFazendaById(id));
    }
    
    public Page<FazendaResponseDto> findAll(Integer page, Integer sizePage) {
    	return repository.findAll(PageRequest.of(page, sizePage))
    				.map(f -> mapper.toResponseDTO(f));
    }
    
    public FazendaResponseDto buscarById(Long id) throws NotFoundException { 
    	return mapper.toResponseDTO(this.buscarFazendaById(id));
    }

    private Fazenda buscarFazendaById(Long id) throws NotFoundException {
        Optional<Fazenda> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new NotFoundException("Fazenda não encontrada!");
        }
        
        return op.get();
    }
}
