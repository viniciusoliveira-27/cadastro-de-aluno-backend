package org.example.domain.gateway;

import java.util.List;

import org.example.domain.activity.Activity;

public interface ActivityGateway {

    public void create(final Activity anActivity);
    public void delete(final String anId);
    public List<Activity> findAll();
    
}
