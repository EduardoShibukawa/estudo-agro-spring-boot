package com.github.eduardoshibukawa.totvsagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FazendaPostDto {

    @NotNull
    @Size(max = 200)
	public String nome;

    @NotBlank
	public String cnpj;

    @NotNull
    public EnderecoPostDto endereco;
    
}
