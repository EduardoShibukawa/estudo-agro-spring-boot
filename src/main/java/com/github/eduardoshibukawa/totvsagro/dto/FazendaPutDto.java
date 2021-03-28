package com.github.eduardoshibukawa.totvsagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FazendaPutDto {
	
	@NotBlank
    @Size(max = 200)
    private String nome;
	
	public FazendaPutDto(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
