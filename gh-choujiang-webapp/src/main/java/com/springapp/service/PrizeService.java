package com.springapp.service;

import com.springapp.model.PrizeModel;

import java.util.List;

/**
 * Created by songlinwei on 17/1/13.
 */
public interface PrizeService {

    public int insertPrize(PrizeModel prizeModel);

    public int updatePrize(PrizeModel prizeModel);

    public PrizeModel selectPrize(int prizeId);

    public List<PrizeModel> listActivityIdPrize(int activityId);

    public List<PrizeModel> listPrize(int page, int pageSize);


}
