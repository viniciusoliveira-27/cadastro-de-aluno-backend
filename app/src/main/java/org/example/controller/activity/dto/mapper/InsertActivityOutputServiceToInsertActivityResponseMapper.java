package org.example.controller.activity.dto.mapper;


import java.util.function.Function;

import org.example.controller.activity.dto.InsertActivityResponseDto;
import org.example.service.activity.dto.InsertActivityOutputDto;

public class InsertActivityOutputServiceToInsertActivityResponseMapper implements Function<InsertActivityOutputDto, InsertActivityResponseDto> {

    public static InsertActivityOutputServiceToInsertActivityResponseMapper build() {
        return new InsertActivityOutputServiceToInsertActivityResponseMapper();
    }

    @Override
    public InsertActivityResponseDto apply(final InsertActivityOutputDto input) {
        return new InsertActivityResponseDto(
                input.id(),
                input.nome(),
                input.serie(), 
                input.escola(), 
                input.periodo(), 
                input.valor(), 
                input.data(),
                input.createdAt(),
                input.updatedAt());

    }
    
}
