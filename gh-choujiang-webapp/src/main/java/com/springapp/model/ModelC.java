package com.springapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by songlinwei on 17/1/16.
 */
public class ModelC {
    //抽奖记录
    public static List<PrizeLogModel> prizeLogList = new ArrayList<PrizeLogModel>();
    //奖品池子
    public static List<PrizeModel> prizeModelList = new ArrayList<PrizeModel>();

    static {
        PrizeModel prizeModel = new PrizeModel();
        prizeModel.setActivityId(1);
        prizeModel.setPrizeName("笔记本");
        prizeModel.setPrizeInfo("我是一等奖啊 我是笔记本");
        prizeModel.setPrizeNum(10);
        prizeModel.setPrizeProbability("0.002");
        prizeModelList.add(prizeModel);
        prizeModel = new PrizeModel();
        prizeModel.setActivityId(1);
        prizeModel.setPrizeName("手机");
        prizeModel.setPrizeInfo("我是二等奖啊 我是手机");
        prizeModel.setPrizeNum(5);
        prizeModel.setPrizeProbability("0.05");
        prizeModelList.add(prizeModel);
        prizeModel = new PrizeModel();
        prizeModel.setActivityId(1);
        prizeModel.setPrizeName("可乐");
        prizeModel.setPrizeInfo("我是三等奖啊 我是可乐");
        prizeModel.setPrizeNum(10);
        prizeModel.setPrizeProbability("0.08");
        prizeModelList.add(prizeModel);
        prizeModel = new PrizeModel();
        prizeModel.setActivityId(1);
        prizeModel.setPrizeName("米线10元代金卷");
        prizeModel.setPrizeInfo("我是四等奖啊 我是米线10元代金卷");
        prizeModel.setPrizeNum(10);
        prizeModel.setPrizeProbability("0.6");
        prizeModelList.add(prizeModel);
    }

    public static void addPrizeLogList(int activityId, int prizeId, String uName) {
        PrizeLogModel prizeLogModel = new PrizeLogModel();
        prizeLogModel.setActivityId(activityId);
        prizeLogModel.setPrizeId(prizeId);
        prizeLogModel.setuName(uName);
        prizeLogModel.setPrizeLogDate(new Date());
        prizeLogList.add(prizeLogModel);
    }

    public static void selectPrizeLogList() {
        for (PrizeLogModel prizeLogModel : prizeLogList) {
            System.out.println(prizeLogModel.toString());
        }
    }


}
