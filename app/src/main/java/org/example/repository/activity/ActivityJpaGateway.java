package org.example.repository.activity;

import java.util.List;

import org.example.domain.activity.Activity;
import org.example.domain.gateway.ActivityGateway;
import org.example.repository.activity.jpa.ActivityJpaRepository;

public class ActivityJpaGateway implements ActivityGateway {

    private ActivityJpaRepository activityRepository;

    private ActivityJpaGateway(final ActivityJpaRepository aRepository) {
        this.activityRepository = aRepository;
    }

    public static ActivityJpaGateway build(final ActivityJpaRepository aRepository) {
        return new ActivityJpaGateway(aRepository);
    }

    @Override
    public void create(Activity anActivity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(String anId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Activity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
