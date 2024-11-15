package org.example.controller.activity;

import org.example.controller.activity.dto.InsertActivityRequestDto;
import org.example.controller.activity.dto.InsertActivityResponseDto;
import org.example.controller.activity.dto.ListActivitiesResponseDto;
import org.example.controller.activity.dto.mapper.InsertActivityOutputServiceToInsertActivityResponseMapper;
import org.example.controller.activity.dto.mapper.InsertActivityRequestToInsertActivityServiceMapper;
import org.example.controller.activity.dto.mapper.ListActivitiesToListActivitiesResponseMapper;
import org.example.repository.activity.ActivityJpaGateway;
import org.example.repository.activity.jpa.ActivityJpaRepository;
import org.example.service.activity.implementation.ActivityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityJpaRepository activityRepository;

    @GetMapping
    public ResponseEntity<ListActivitiesResponseDto> listActivities() {
        //instanciar o serviçi
        final var aGateway = ActivityJpaGateway.build(activityRepository);  
        final var aService = ActivityServiceImplementation.build(aGateway);

        final var aList = aService.listActivities(); 

        final var aResponse = ListActivitiesToListActivitiesResponseMapper
                .build()
                .apply(aList);
        
        return ResponseEntity.ok().body(aResponse);
    }    
    
    @PostMapping
    public ResponseEntity<InsertActivityResponseDto> insertActivity(@RequestBody InsertActivityRequestDto input) {

        final var aGateway = ActivityJpaGateway.build(activityRepository);  
        final var aService = ActivityServiceImplementation.build(aGateway);

        final var aServiceInput = InsertActivityRequestToInsertActivityServiceMapper.build()
                .apply(input);

        final var aServiceResponse = aService.insertActivity(aServiceInput);

        final var aResponse = InsertActivityOutputServiceToInsertActivityResponseMapper.build()
                .apply(aServiceResponse);

        return ResponseEntity.ok().body(aResponse);
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityById(@PathVariable("id") final String anId) {

        final var aGateway = ActivityJpaGateway.build(activityRepository);  
        final var aService = ActivityServiceImplementation.build(aGateway);

        aService.removeActivity(anId);

        return ResponseEntity.noContent().build();
        
    }
}
