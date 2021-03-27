package com.github.eduardoshibukawa.totvsagro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.github.eduardoshibukawa.totvsagro.dto.FazendaPostDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaPutDto;
import com.github.eduardoshibukawa.totvsagro.dto.FazendaResponseDto;
import com.github.eduardoshibukawa.totvsagro.service.FazendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.NotFoundException;

@Controller
@RequestMapping("fazenda")
public class FazendaController {

	@Autowired
	private FazendaService fazendaService;

	@GetMapping("{id}")
	public ResponseEntity<FazendaResponseDto> buscarPorID(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(fazendaService.buscarById(id));
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Long> post(@RequestBody FazendaPostDto dto) {
		Long id = fazendaService.salvar(dto);

		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(id)
					.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> put(@PathVariable Long id, @RequestBody @Valid FazendaPutDto dto) {
		try {
			fazendaService.atualizar(id, dto);

			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			fazendaService.deletar(id);
			
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<FazendaResponseDto>> findAll(
			@RequestParam(name = "page", defaultValue = "0") Integer pageNumber, 
			@RequestParam(name = "page-size", defaultValue = "50") Integer pageSize) {
		final Page<FazendaResponseDto> page = fazendaService.findAll(pageNumber, pageSize);
		
		return ResponseEntity.ok(page.toList());
	}

}
