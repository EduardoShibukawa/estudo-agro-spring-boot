package com.github.eduardoshibukawa.totvsagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FazendaPutDto {

    @NotBlank
    @Size(max = 200)
    public String nome;
}
