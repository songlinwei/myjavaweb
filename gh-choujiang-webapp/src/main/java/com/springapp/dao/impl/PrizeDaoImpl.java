package com.springapp.dao.impl;

import com.springapp.dao.PrizeDao;
import com.springapp.model.PrizeModel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songlinwei on 17/1/13.
 */
//@Repository("prizeDao")
@Repository
public class PrizeDaoImpl implements PrizeDao {
    private static final String NAMESPACE = "com.springapp.dao.PrizeDao.";
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    @Override
    public int insertPrize(PrizeModel prizeModel) {
        return sqlSession.insert(NAMESPACE + "insertPrize", prizeModel);
    }

    @Override
    public int updatePrize(PrizeModel prizeModel) {
        return sqlSession.update(NAMESPACE + "updatePrize", prizeModel);
    }

    @Override
    public PrizeModel selectPrize(int prizeId) {
        return sqlSession.selectOne(NAMESPACE + "selectPrize", prizeId);
    }

    @Override
    public List<PrizeModel> listActivityIdPrize(int activityId) {
        return sqlSession.selectList(NAMESPACE + "listActivityIdPrize", activityId);
    }

    @Override
    public List<PrizeModel> listPrize(int page, int pageSize) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", page);
        params.put("length", pageSize);
        return sqlSession.selectList(NAMESPACE + "listPrize", params);
    }
}
