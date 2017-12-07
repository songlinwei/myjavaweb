package com.springapp.dao;

import com.springapp.model.PrizeModel;

import java.util.List;

/**
 * Created by songlinwei on 17/1/13.
 */
public interface PrizeDao {
    int insertPrize(PrizeModel prizeModel);

    int updatePrize(PrizeModel prizeModel);

    PrizeModel selectPrize(int prizeId);

    List<PrizeModel> listActivityIdPrize(int activityId);

    List<PrizeModel> listPrize(int page, int pageSize);
}
