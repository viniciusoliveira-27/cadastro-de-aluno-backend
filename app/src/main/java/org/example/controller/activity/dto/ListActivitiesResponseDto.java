package org.example.controller.activity.dto;

import java.util.List;

public record ListActivitiesResponseDto (
    List<ActivityDto> activities
) {
    
}
