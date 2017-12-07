package com.springapp.dao.impl;

import com.springapp.dao.ActivityDao;
import com.springapp.model.ActivityModel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songlinwei on 17/1/13.
 */
//@Repository("activityDao")
@Repository
public class ActivityDaoImpl implements ActivityDao {
    private static final String NAMESPACE = "com.springapp.dao.ActivityDao.";
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    @Override
    public int insertActivity(ActivityModel activity) {
        return sqlSession.insert(NAMESPACE + "insertActivity", activity);
    }

    @Override
    public int updateActivity(ActivityModel activity) {
        return sqlSession.update(NAMESPACE + "updateActivity", activity);
    }

    @Override
    public ActivityModel selectActivity(int activityId) {
        return sqlSession.selectOne(NAMESPACE + "selectActivity", activityId);
    }

    @Override
    public List<ActivityModel> listActivity(int page, int pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", page);
        params.put("pageSize", pageSize);
        return sqlSession.selectList(NAMESPACE + "listActivity", params);
    }
}
