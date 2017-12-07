package com.springapp.service.impl;

import com.springapp.dao.ActivityDao;
import com.springapp.model.ActivityModel;
import com.springapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songlinwei on 17/1/13.
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;

    @Override
    public int insertActivity(ActivityModel activity) {
        return activityDao.insertActivity(activity);
    }

    @Override
    public int updateActivity(ActivityModel activity) {
        return activityDao.updateActivity(activity);
    }

    @Override
    public ActivityModel selectActivity(int activityId) {
        return activityDao.selectActivity(activityId);
    }

    @Override
    public List<ActivityModel> listActivity(int page, int pageSize) {
        return activityDao.listActivity(page,pageSize);
    }
}
