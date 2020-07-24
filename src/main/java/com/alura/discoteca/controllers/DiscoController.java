package com.alura.discoteca.controllers;

import com.alura.discoteca.models.Disco;
import com.alura.discoteca.repository.DiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discos")
public class DiscoController {

    @Autowired
    public DiscoRepository discoRepository;

    @PostMapping
    public Disco create(@RequestBody Disco disco) {
        return discoRepository.save(disco);
    }

    @GetMapping
    public List<Disco> read() {
        List<Disco> discos = new ArrayList<>();
        discoRepository.findAll().forEach(discos::add);
        return discos;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, Disco disco) {
        disco.setId(id);
        discoRepository.save(disco);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        discoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
