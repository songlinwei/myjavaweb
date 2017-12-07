package com.springapp.service.impl;

import com.springapp.dao.PrizeLogDao;
import com.springapp.model.PrizeLogModel;
import com.springapp.service.PrizeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by songlinwei on 17/1/13.
 */
@Service("prizeLogService")
public class PrizeLogServiceImpl implements PrizeLogService {
    @Autowired
    PrizeLogDao prizeLogDao;

    @Override
    public int insertPrizeLog(PrizeLogModel prizeLogModel) {
        return prizeLogDao.insertPrizeLog(prizeLogModel);
    }
}
