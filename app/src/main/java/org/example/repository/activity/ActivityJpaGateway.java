package org.example.repository.activity;

import java.util.List;
import java.util.stream.Collectors;

import org.example.domain.activity.Activity;
import org.example.domain.gateway.ActivityGateway;
import org.example.repository.activity.jpa.ActivityJpaEntity;
import org.example.repository.activity.jpa.ActivityJpaRepository;
import org.springframework.dao.OptimisticLockingFailureException;

import jakarta.persistence.PersistenceException;

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
        final var anActivityEntity = ActivityJpaEntity.from(anActivity);

        try {
            this.activityRepository.save(anActivityEntity);
        } catch (IllegalArgumentException e) {
            throw new PersistenceException(e.getMessage());
        } catch (OptimisticLockingFailureException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(final String anId) {
        try {
            this.activityRepository.deleteById(anId);
        } catch (IllegalArgumentException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Activity> findAll() {
        final var aList = this.activityRepository.findAll();

        return aList.stream()
                .map(activityEntity -> activityEntity.toModel())
                .collect(Collectors.toList());
    }

}
