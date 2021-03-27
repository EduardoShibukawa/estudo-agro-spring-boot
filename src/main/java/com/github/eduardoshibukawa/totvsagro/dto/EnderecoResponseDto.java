package com.github.eduardoshibukawa.totvsagro.dto;

import java.util.Objects;

import com.github.eduardoshibukawa.totvsagro.model.Endereco;

public class EnderecoResponseDto {

    public String cidade;
    public String uf;
    public String logradouro;
    
    public EnderecoResponseDto(Endereco endereco) {
        this.cidade 
            = Objects.requireNonNull(endereco, "Endereço não deve ser vazio!")
                .getCidade();
        this.uf = endereco.getUF();
        this.logradouro = endereco.getLogradouro();
    }
}
