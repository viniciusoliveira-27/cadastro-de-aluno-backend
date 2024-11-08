package org.example.service.activity.dto;

import java.time.Instant;

public record ListActivitiesOutputDto(
    String id,
    String nome,
    String serie,
    String escola,
    String periodo,
    double valor,
    Instant data,
    Instant createdAt,
    Instant updatedAt) {
    
}
