package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.repository.InvestimentoRepository;

@Service
public class InvestimentoService {
    private final InvestimentoRepository repository;

    public InvestimentoService(InvestimentoRepository repository) {
        this.repository = repository;
    }

    
}
