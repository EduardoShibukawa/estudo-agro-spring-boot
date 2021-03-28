package com.github.eduardoshibukawa.totvsagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EnderecoPostDto {
    
    @NotBlank
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    private String uf;

    @NotBlank
    private String logradouro;
    
    public EnderecoPostDto(String cidade, String uf, String logradouro) {
		this.cidade = cidade;
		this.uf = uf;
		this.logradouro = logradouro;
	}

	public EnderecoPostDto() {}
    
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
    
    
}
