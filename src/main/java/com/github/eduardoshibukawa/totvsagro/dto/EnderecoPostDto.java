package com.github.eduardoshibukawa.totvsagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EnderecoPostDto {
    
    @NotBlank
    public String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    public String uf;

    @NotBlank
    public String logradouro;
}
