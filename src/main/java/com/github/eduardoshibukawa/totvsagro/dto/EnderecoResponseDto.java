package com.github.eduardoshibukawa.totvsagro.dto;

public class EnderecoResponseDto {

	private Long id;
    private String cidade;
    private String uf;
    private String logradouro;
    
    public EnderecoResponseDto() {}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
