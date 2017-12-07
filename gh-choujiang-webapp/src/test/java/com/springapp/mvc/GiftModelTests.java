//package com.springapp.mvc;
//
//import com.springapp.model.Tt;
//import com.springapp.util.LotteryUtil;
//
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * Created by songlinwei on 17/1/11.
// */
//public class GiftModelTests {
//
//
//    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0l,
//            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10000),
//            new DefaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
//
//    /**
//     * The default thread factory
//     */
//    static class DefaultThreadFactory implements ThreadFactory {
//
//        private static final AtomicInteger poolNumber = new AtomicInteger(1);
//        private final ThreadGroup group;
//        private final AtomicInteger threadNumber = new AtomicInteger(1);
//        private final String namePrefix;
//
//        DefaultThreadFactory() {
//            SecurityManager s = System.getSecurityManager();
//            group = (s != null) ? s.getThreadGroup() :
//                    Thread.currentThread().getThreadGroup();
//            namePrefix = "songlinpool-" +
//                    poolNumber.getAndIncrement() +
//                    "-thread-";
//        }
//
//        @Override
//        public Thread newThread(Runnable r) {
//            Thread t = new Thread(group, r,
//                    namePrefix + threadNumber.getAndIncrement(),
//                    0);
//            if (t.isDaemon())
//                t.setDaemon(false);
//            if (t.getPriority() != Thread.NORM_PRIORITY)
//                t.setPriority(Thread.NORM_PRIORITY);
//            return t;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println("hello word");
//        List<GiftModel> giftModelList = LotteryUtil.init1();
//        giftModelList = LotteryUtil.tempSumRate(giftModelList);
//        for (GiftModel giftModel : giftModelList) {
//            System.out.println("giftModelList-" + giftModel.toString());
//        }
//        System.out.println();
//        System.out.println();
//        List<GiftModel> giftModelList2 = LotteryUtil.init1();
//
//        try {
//            for (int i = 0; i < 10; i++) {
//                fExecutors(giftModelList, giftModelList2);
////            fThread(giftModelList, giftModelList2);
//            }
//        } finally {
//            threadPoolExecutor.shutdown();
//            while (true) {
//                if (threadPoolExecutor.isTerminated()) {
//                    break;
//                }
//                try {
//                    Thread.sleep(500 * 2);
//                } catch (InterruptedException e) {
//                }
//            }
//        }
//    }
//
//    /**
//     * 线程池实现
//     */
//    private static void fExecutors(final List<GiftModel> giftModelList, final List<GiftModel> giftModelList2) {
//        threadPoolExecutor.submit(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//
//                            Thread.sleep(new Random().nextInt(1000));
//                            for (int i = 0; i < 3; i++) {
//                                fThread(giftModelList, giftModelList2);
//                            }
//                        } catch (Exception e) {
//                        }
//                    }
//                }
//        );
//    }
//
//    public static void fThread(List<GiftModel> giftModelList, List<GiftModel> giftModelList2) {
//        int i = LotteryUtil.lottery(giftModelList);
//        if (i == -1) {
//            System.out.println("奖品概率表为空");
//        } else if (i == 3) {
//            System.out.println("抽奖成功 你抽中的是：" + giftModelList.get(i).toString());
//        } else {
//            Tt.tt3(giftModelList2, i);
//        }
//
//    }
//
//
//}
