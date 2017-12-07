package com.springapp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by songlinwei on 17/1/6.
 * 抽奖工具类
 */
public class LotteryUtil {

//    /**
//     * 抽奖
//     *
//     * @param orignalRates 原始的概率列表，保证顺序和实际物品对应
//     * @return 物品的索引
//     */
//    public static int lottery(List<Double> orignalRates) {
//        if (orignalRates == null || orignalRates.isEmpty()) {
//            return -1;
//        }
//        int size = orignalRates.size();
//
//        // 计算总概率，这样可以保证不一定总概率是1
//        double sumRate = 0d;
//        for (double rate : orignalRates) {
//            sumRate += rate;
//        }
//
//        // 计算每个物品在总概率的基础下的概率情况
//        List<Double> sortOrignalRates = new ArrayList<Double>(size);
//        Double tempSumRate = 0d;
//        for (double rate : orignalRates) {
//            tempSumRate += rate;
//            sortOrignalRates.add(tempSumRate / sumRate);
//            System.out.println("22----"+(tempSumRate / sumRate));
//        }
//
//        // 根据区块值来获取抽取到的物品索引
//        double nextDouble = Math.random();
//        sortOrignalRates.add(nextDouble);
//        Collections.sort(sortOrignalRates);
//        return sortOrignalRates.indexOf(nextDouble);
//    }

    /**
     * 抽奖
     *
     * @param orignalRates 原始的概率列表，保证顺序和实际物品对应
     * @return 物品的索引
     */
    public static int lottery(List<Double> orignalRates) {
        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }
        return lotterys(sortOrignalRatesM(orignalRates));
    }

    private static List<Double> sortOrignalRatesM(List<Double> orignalRates) {
        double sumRate = sumRateM(orignalRates);
        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(orignalRates.size());
        Double tempSumRate = 0d;
        for (double rate : orignalRates) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
            System.out.println("22----" + (tempSumRate / sumRate));
        }
        return sortOrignalRates;
    }

    private static double sumRateM(List<Double> orignalRates) {
        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : orignalRates) {
            sumRate += rate;
        }
        return sumRate;
    }

    public static int lotterys(List<Double> sortOrignalRates) {
        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);
        return sortOrignalRates.indexOf(nextDouble);
    }


}
