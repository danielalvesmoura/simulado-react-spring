package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Calculo;

public interface CalculoRepository extends JpaRepository<Calculo, Long> {
    
}
