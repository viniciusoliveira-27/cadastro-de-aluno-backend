package org.example.controller.activity.dto.mapper;

import java.util.function.Function;

import org.example.controller.activity.dto.InsertActivityRequestDto;
import org.example.service.activity.dto.InsertActivityInputDto;

public class InsertActivityRequestToInsertActivityServiceMapper implements Function<InsertActivityRequestDto, InsertActivityInputDto> {

    public static InsertActivityRequestToInsertActivityServiceMapper build() {
        return new InsertActivityRequestToInsertActivityServiceMapper();
    }

    @Override
    public InsertActivityInputDto apply(final InsertActivityRequestDto input) {

        return new InsertActivityInputDto(
                input.nome(),
                input.serie(), 
                input.escola(), 
                input.periodo(), 
                input.valor(), 
                input.data());
    }
    
}
