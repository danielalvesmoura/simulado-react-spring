package com.example.backend.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.CalculoRequest;
import com.example.backend.dto.CalculoResponse;
import com.example.backend.model.Investimento;
import com.example.backend.service.InvestimentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/investimentos")
@CrossOrigin(origins = "https://localhost:3306")
public class InvestimentoController {
    private final InvestimentoService service;

    InvestimentoController(InvestimentoService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public ResponseEntity<CalculoResponse> calcular(@Valid @RequestBody CalculoRequest request) {
        BigDecimal valorFinal = service.calcularValorFinal(request);

        CalculoResponse response = new CalculoResponse(valorFinal);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Investimento> salvar(@Valid @RequestBody CalculoRequest request) {
        Investimento investimentoSalvo = service.salvar(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(investimentoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Investimento>> listarTodos() {
        List<Investimento> investimentos = service.listarTodos();

        return ResponseEntity.ok(investimentos);
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodos() {
        service.excluirTodos();

        return ResponseEntity.noContent().build();
    }
}