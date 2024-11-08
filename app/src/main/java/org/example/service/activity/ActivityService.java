package org.example.service.activity;

import java.util.List;
import org.example.service.activity.dto.InsertActivityInputDto;
import org.example.service.activity.dto.InsertActivityOutputDto;
import org.example.service.activity.dto.ListActivitiesOutputDto;

public interface ActivityService {
    
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput);

    public void removeActivity(final String anId);

    public List<ListActivitiesOutputDto> listActivities();
    
    public double calculateBalance();

}
