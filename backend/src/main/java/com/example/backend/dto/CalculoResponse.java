package com.example.backend.dto;

import java.math.BigDecimal;

public class CalculoResponse {
    private BigDecimal valorFinal;

    public CalculoResponse(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getValorFinal() {
        return this.valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}
