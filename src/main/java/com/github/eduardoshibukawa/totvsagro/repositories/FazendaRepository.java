package com.github.eduardoshibukawa.totvsagro.repositories;

import com.github.eduardoshibukawa.totvsagro.model.Fazenda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    
}
