package org.example.controller.activity.dto;

import java.time.Instant;

public record InsertActivityRequestDto(
    String nome,
    String serie,
    String escola,
    String periodo,
    double valor,
    Instant data) {
} 
