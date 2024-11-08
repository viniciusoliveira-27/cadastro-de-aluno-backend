package org.example.service.activity.implementation;

import java.util.List;
import java.util.stream.Collectors;


import org.example.domain.gateway.ActivityGateway;
import org.example.service.activity.ActivityService;
import org.example.service.activity.dto.InsertActivityInputDto;
import org.example.service.activity.dto.InsertActivityOutputDto;
import org.example.service.activity.dto.ListActivitiesOutputDto;
import org.example.service.activity.dto.mapper.ActivityToInsertActivityOutputMapper;
import org.example.service.activity.dto.mapper.ActivityToListActivitiesOutputMapper;
import org.example.service.activity.dto.mapper.InsertActivityInputToActivityMapper;

public class ActivityServiceImplementation implements ActivityService {

    private ActivityGateway activityGateway;

    private ActivityServiceImplementation(final ActivityGateway aGateway) {
        this.activityGateway = aGateway;
    }

    public static ActivityServiceImplementation build(final ActivityGateway aGateway) {
        return new ActivityServiceImplementation(aGateway);
    }

    @Override
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput) {
        final var anActivity = InsertActivityInputToActivityMapper.build().apply(anInput);

        this.activityGateway.create(anActivity);

        return ActivityToInsertActivityOutputMapper.build().apply(anActivity);
    }

    @Override
    public void removeActivity(String anId) {
        this.activityGateway.delete(anId);

    }

    @Override
    public List<ListActivitiesOutputDto> listActivities() {
        final var aList = this.activityGateway.findAll();

        return aList.stream()
                .map(a -> ActivityToListActivitiesOutputMapper
                .build()
                .apply(a))
                .collect(Collectors.toList());


    }

    @Override
    public double calculateBalance() {
        final var aList = this.activityGateway.findAll();

        if(aList == null || aList.size() == 0){
            return 0;
        }
        // fazendo a soma dos pagamentos
        return aList.stream()
            .mapToDouble(a -> a.getValor())
            .sum();
 
    }
    
}
