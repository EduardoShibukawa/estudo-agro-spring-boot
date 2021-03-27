package com.github.eduardoshibukawa.totvsagro.dto;

import com.github.eduardoshibukawa.totvsagro.model.Fazenda;

public class FazendaResponseDto {

    public String nome;
    public String cnpj;
    public EnderecoResponseDto endereco;

    public FazendaResponseDto(Fazenda fazenda) {
        this.nome = fazenda.getNome();
        this.cnpj = fazenda.getNome();
        this.endereco = new EnderecoResponseDto(fazenda.getEndereco());
    }
    
}
