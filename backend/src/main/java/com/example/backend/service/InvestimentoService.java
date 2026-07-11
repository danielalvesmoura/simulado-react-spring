package com.example.backend.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.dto.CalculoRequest;
import com.example.backend.model.Investimento;
import com.example.backend.repository.InvestimentoRepository;

@Service
public class InvestimentoService {
    private final InvestimentoRepository repository;

    public InvestimentoService(InvestimentoRepository repository) {
        this.repository = repository;
    }

    public BigDecimal calcularValorFinal(CalculoRequest request) {
        BigDecimal taxaDecimal = request.getJurosMensal().divide(new BigDecimal("100"), MathContext.DECIMAL128);

        BigDecimal fatorJuros = BigDecimal.ONE.add(taxaDecimal);

        BigDecimal valorFinal = request.getValorInicial().multiply(
            fatorJuros.pow(request.getPrazoMeses(), MathContext.DECIMAL128)
        );

        return valorFinal.setScale(2, RoundingMode.HALF_UP);
    }

    public Investimento salvar(CalculoRequest request) {
        BigDecimal valorFinal = calcularValorFinal(request);

        Investimento investimento = new Investimento(
            request.getValorInicial(),
            request.getPrazoMeses(),
            request.getJurosMensal(),
            valorFinal
        );

        return repository.save(investimento);
    }

    public List<Investimento> listarTodos() {
        return repository.findAll();
    }

    public void excluirTodos() {
        repository.deleteAll();
    }
}
