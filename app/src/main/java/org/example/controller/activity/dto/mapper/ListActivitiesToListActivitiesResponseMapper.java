package org.example.controller.activity.dto.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.example.controller.activity.dto.ActivityDto;
import org.example.controller.activity.dto.ListActivitiesResponseDto;
import org.example.service.activity.dto.ListActivitiesOutputDto;

public class ListActivitiesToListActivitiesResponseMapper implements
        Function<List<ListActivitiesOutputDto>, ListActivitiesResponseDto> {

    public static ListActivitiesToListActivitiesResponseMapper build(){
        return new ListActivitiesToListActivitiesResponseMapper();
    }

    @Override
    public ListActivitiesResponseDto apply(final List<ListActivitiesOutputDto> input) {

        final var aList = input.stream()
                .map(a -> new ActivityDto(
                        a.id(), 
                        a.nome(), 
                        a.serie(), 
                        a.escola(), 
                        a.periodo(), 
                        a.valor(), 
                        a.data()))
                .collect(Collectors.toList());


        return new ListActivitiesResponseDto(aList);
    }
}   
