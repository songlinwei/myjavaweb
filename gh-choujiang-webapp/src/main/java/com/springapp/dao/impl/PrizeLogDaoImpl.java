package com.springapp.dao.impl;

import com.springapp.dao.PrizeLogDao;
import com.springapp.model.PrizeLogModel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by songlinwei on 17/1/13.
 */
//@Repository("prizeLogDao")
@Repository
public class PrizeLogDaoImpl implements PrizeLogDao {
    private static final String NAMESPACE = "com.springapp.dao.PrizeLogDao.";
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    @Override
    public int insertPrizeLog(PrizeLogModel prizeLogModel) {
        return sqlSession.insert(NAMESPACE + "insertPrizeLog", prizeLogModel);
    }

}
