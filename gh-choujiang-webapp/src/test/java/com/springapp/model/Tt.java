//package com.springapp.model;
//
//import java.util.List;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
///**
// * Created by songlinwei on 17/1/11.
// */
//public class Tt {
//    private static Lock lock = new ReentrantLock();
//    private static ReadWriteLock rwLock = new ReentrantReadWriteLock();
//
//    public synchronized static void tt(List<GiftModel> giftModelList2, int i) {
//        String tName = Thread.currentThread().getName();
//        GiftModel giftModel = giftModelList2.get(i);
//        if (giftModel.getGitfNum() > 0) {
//            giftModel.setGitfNum(giftModel.getGitfNum() - 1);
//            System.out.println(i + "抽奖成功" + tName + "你抽中的是：" + giftModel.toString());
//        } else {
//            System.out.println(i + "奖品没有了" + tName);
//        }
//    }
//
//    public static void tt2(List<GiftModel> giftModelList2, int i) {
//        String tName = Thread.currentThread().getName();
//        lock.lock();
//        try {
//            GiftModel giftModel = giftModelList2.get(i);
//            if (giftModel.getGitfNum() > 0) {
//                giftModel.setGitfNum(giftModel.getGitfNum() - 1);
//                System.out.println(i + "抽奖成功" + tName + "你抽中的是：" + giftModel.toString());
//            } else {
//                System.out.println(i + "奖品没有了" + tName);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//
//    public static void tt3(List<GiftModel> giftModelList2, int i) {
//        String tName = Thread.currentThread().getName();
//        rwLock.writeLock().lock();
//        try {
//            GiftModel giftModel = giftModelList2.get(i);
//            if (giftModel.getGitfNum() > 0) {
//                giftModel.setGitfNum(giftModel.getGitfNum() - 1);
//                System.out.println(i + "抽奖成功" + tName + "你抽中的是：" + giftModel.toString());
//            } else {
//                System.out.println(i + "奖品没有了" + tName);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            rwLock.writeLock().unlock();
//        }
//    }
//}
