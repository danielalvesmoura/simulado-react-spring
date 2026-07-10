package com.example.backend.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CalculoRequest {
    @DecimalMin(value = "0.01", message = "maior que 0")
    @NotNull(message = "obrigatório")
    private BigDecimal valorInicial;

    @NotNull(message = "obrigatório")
    @Min(value = 1, message = "pelo menos 1")
    private Integer prazoMeses;

    @DecimalMin(value = "0.0", message = "não pode ser negativo")
    @NotNull(message = "obrigatório")
    private BigDecimal jurosMensal;

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
}
