package com.springapp.service.impl;

import com.springapp.dao.PrizeDao;
import com.springapp.model.PrizeModel;
import com.springapp.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songlinwei on 17/1/13.
 */
@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {
    @Autowired
    PrizeDao prizeDao;

    @Override
    public int insertPrize(PrizeModel prizeModel) {
        return prizeDao.insertPrize(prizeModel);
    }

    @Override
    public int updatePrize(PrizeModel prizeModel) {
        return prizeDao.updatePrize(prizeModel);
    }

    @Override
    public PrizeModel selectPrize(int prizeId) {
        return prizeDao.selectPrize(prizeId);
    }

    @Override
    public List<PrizeModel> listActivityIdPrize(int activityId) {
        return prizeDao.listActivityIdPrize(activityId);
    }

    @Override
    public List<PrizeModel> listPrize(int page, int pageSize) {
        return prizeDao.listPrize(page, pageSize);
    }
}
