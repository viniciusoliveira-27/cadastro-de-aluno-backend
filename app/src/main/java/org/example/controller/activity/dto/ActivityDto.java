package org.example.controller.activity.dto;

import java.time.Instant;

public record ActivityDto (
    String id,
    String nome,
    String serie,
    String escola,
    String periodo,
    double valor,
    Instant data) {
    
}
