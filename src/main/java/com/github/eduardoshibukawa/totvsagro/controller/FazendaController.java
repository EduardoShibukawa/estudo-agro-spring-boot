package com.github.eduardoshibukawa.totvsagro.controller;

import java.net.URI;
import java.util.Optional;

import com.github.eduardoshibukawa.totvsagro.model.Fazenda;
import com.github.eduardoshibukawa.totvsagro.service.FazendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("fazenda")
public class FazendaController {
    
    @Autowired
    private FazendaService fazendaService;
    
    @GetMapping("{id}")
    public ResponseEntity<Fazenda> buscarPorID(@PathVariable("id") Long id) {
        Optional<Fazenda> op = fazendaService.buscar(id);

        if (op.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(op.get());
    }

    @PostMapping
    public ResponseEntity<Fazenda> post(@RequestBody Fazenda fazenda){
        Fazenda salvo = fazendaService.salvar(fazenda);
        
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(salvo.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(fazenda);
    }

    @PutMapping("{id}")
    public ResponseEntity<Fazenda> put(@RequestBody Fazenda fazendaDTO) {
        Fazenda fazenda = fazendaService.buscar(fazenda.getId())

        return ResponseEntity.noContent().build();
    }
}

