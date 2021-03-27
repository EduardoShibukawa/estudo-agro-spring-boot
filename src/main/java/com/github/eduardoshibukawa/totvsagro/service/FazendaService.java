package com.github.eduardoshibukawa.totvsagro.service;

import java.util.Optional;

import com.github.eduardoshibukawa.totvsagro.model.Fazenda;
import com.github.eduardoshibukawa.totvsagro.repositories.FazendaRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository repository;

    public Fazenda salvar(Fazenda fazenda) {
        return repository.save(fazenda);
    }

    public Optional<Fazenda> buscar(Long id) {
        return repository.findById(id);
    }
}
