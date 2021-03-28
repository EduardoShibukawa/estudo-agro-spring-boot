package com.github.eduardoshibukawa.totvsagro.dto;

public class FazendaResponseDto {

	private Long id;
    private String nome;
    private String cnpj;
	private EnderecoResponseDto endereco;
    
    public FazendaResponseDto() {}

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
    
    public EnderecoResponseDto getEndereco() {
    	return endereco;
    }
    
    public void setEndereco(EnderecoResponseDto endereco) {
    	this.endereco = endereco;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
