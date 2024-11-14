package org.example.controller.activity.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InsertActivityResponseDto(
    String id,
    String nome,
    String serie,
    String escola,
    String periodo,
    double valor,
    Instant data,
    @JsonProperty("created_at")Instant createdAt,
    @JsonProperty("updated_at")Instant updatedAt) {
    
}
