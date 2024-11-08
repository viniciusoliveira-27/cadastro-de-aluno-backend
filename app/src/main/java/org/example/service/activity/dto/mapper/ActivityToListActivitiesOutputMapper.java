package org.example.service.activity.dto.mapper;

import java.util.function.Function;

import org.example.domain.activity.Activity;
import org.example.service.activity.dto.ListActivitiesOutputDto;

public class ActivityToListActivitiesOutputMapper implements Function <Activity, ListActivitiesOutputDto > {

    public static ActivityToListActivitiesOutputMapper build() {
        return new ActivityToListActivitiesOutputMapper();
    }

    @Override
    public ListActivitiesOutputDto apply(final Activity input) {
        return new ListActivitiesOutputDto(
            input.getId(),
            input.getNome(),
            input.getSerie(),
            input.getEscola(),
            input.getPeriodo().getValue(),
            input.getValor(),
            input.getData(),
            input.getCreatedAt(),
            input.getUpdatedAt());


    }
    
}
