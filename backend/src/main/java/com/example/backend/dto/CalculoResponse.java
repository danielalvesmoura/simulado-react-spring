package com.example.backend.dto;

import java.math.BigDecimal;

public class CalculoResponse {
    private BigDecimal valorTotal;

    public CalculoResponse(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
