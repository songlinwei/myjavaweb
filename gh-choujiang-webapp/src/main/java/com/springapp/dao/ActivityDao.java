package com.springapp.dao;

import com.springapp.model.ActivityModel;

import java.util.List;

/**
 * Created by songlinwei on 17/1/13.
 */
public interface ActivityDao {

    int insertActivity(ActivityModel activity);

    int updateActivity(ActivityModel activity);

    ActivityModel selectActivity(int activityId);

    List<ActivityModel> listActivity(int page, int pageSize);
}
