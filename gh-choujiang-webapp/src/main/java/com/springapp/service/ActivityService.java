package com.springapp.service;

import com.springapp.model.ActivityModel;

import java.util.List;

/**
 * Created by songlinwei on 17/1/13.
 */
public interface ActivityService {

    public int insertActivity(ActivityModel activity);

    public int updateActivity(ActivityModel activity);

    public ActivityModel selectActivity(int activityId);

    public List<ActivityModel> listActivity(int page, int pageSize);

}
