package org.example.service.activity.dto.mapper;

import java.util.function.Function;

import org.example.domain.activity.Activity;
import org.example.service.activity.dto.InsertActivityOutputDto;

public class ActivityToInsertActivityOutputMapper implements Function<Activity, InsertActivityOutputDto>{

    public static ActivityToInsertActivityOutputMapper build() {
        return new ActivityToInsertActivityOutputMapper();
    }

    @Override
    public InsertActivityOutputDto apply(final Activity input) {
        return new InsertActivityOutputDto(
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
