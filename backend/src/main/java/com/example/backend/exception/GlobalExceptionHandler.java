package com.example.backend.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarErroDeValidacao(MethodArgumentNotValidException exception) {
        Map<String,String> erros = new LinkedHashMap<>();

        exception
            .getBindingResult()
            .getFieldErrors()
            .forEach(erro -> erros.put(
                erro.getField(),
                erro.getDefaultMessage()
            ));

        ErroResposta resposta = new ErroResposta(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "dado inválido",
            erros
        );

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(resposta);
    }
}
