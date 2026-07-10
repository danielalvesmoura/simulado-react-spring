package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
    
}