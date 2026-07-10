package com.example.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "investimentos")
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorInicial;

    @Column(nullable = false)
    private Integer prazoMeses;

    @Column(nullable = false)
    private BigDecimal jurosMensal;

    @Column(nullable = false)
    private BigDecimal valorFinal;

    public Investimento() {};

    public Investimento(BigDecimal valorInicial, Integer prazoMeses, BigDecimal jurosMensal, BigDecimal valorFinal) {
        this.valorInicial = valorInicial;
        this.prazoMeses = prazoMeses;
        this.jurosMensal = jurosMensal;
        this.valorFinal = valorFinal;
    }

      public Long getId() {
        return id;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public BigDecimal getJurosMensal() {
        return jurosMensal;
    }

    public void setJurosMensal(BigDecimal jurosMensal) {
        this.jurosMensal = jurosMensal;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}