package org.example.service.activity.dto.mapper;
import org.example.domain.activity.Activity;
import org.example.domain.activity.type.Type;
import org.example.service.activity.dto.InsertActivityInputDto;
import org.example.service.activity.exception.ServiceException;

import java.util.function.Function;

public class InsertActivityInputToActivityMapper implements Function<InsertActivityInputDto, Activity> {

    public static InsertActivityInputToActivityMapper build() {
        return new InsertActivityInputToActivityMapper();
    }

    @Override
    public Activity apply(final InsertActivityInputDto input) {

        if (input.periodo().trim().toUpperCase().equals(Type.MANHA.toString())) {
            final var anActivity = Activity.newActivity(
                input.nome(),
                input.serie(), 
                input.escola(), 
                Type.MANHA,
                input.valor(),
                input.data());

            return anActivity;
        } else if (input.periodo().trim().toUpperCase().equals(Type.TARDE.toString())) {
            final var anActivity = Activity.newActivity(
                input.nome(),
                input.serie(), 
                input.escola(), 
                Type.TARDE,
                input.valor(),
                input.data());

            return anActivity;
        } else {
            throw new ServiceException("Invalid activity type");
        }


    }
    
}
