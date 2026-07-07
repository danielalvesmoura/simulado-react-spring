package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Calculo;
import com.example.backend.repository.CalculoRepository;

@RestController
@RequestMapping("/api/calculo")
public class CalculoController {

    private final CalculoRepository repository;

    public CalculoController(CalculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Calculo> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Calculo criar(@RequestBody Calculo calculo) {
        return repository.save(calculo);
    }
}
