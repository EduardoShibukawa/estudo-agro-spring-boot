package com.github.eduardoshibukawa.totvsagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FazendaPostDto {

    @NotNull
    @Size(max = 200)
	private String nome;

    @NotBlank
	private String cnpj;

    @NotNull
    private EnderecoPostDto endereco;

    public FazendaPostDto() {}
        
	public FazendaPostDto(String nome, String cnpj, EnderecoPostDto endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public EnderecoPostDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoPostDto endereco) {
		this.endereco = endereco;
	}
}
