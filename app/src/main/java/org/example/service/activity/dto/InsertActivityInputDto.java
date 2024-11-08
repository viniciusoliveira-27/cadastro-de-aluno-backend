package org.example.service.activity.dto;

import java.time.Instant;

public record InsertActivityInputDto(
    String nome,
    String serie,
    String escola,
    String periodo,
    double valor,
    Instant data) {
    
    
}
