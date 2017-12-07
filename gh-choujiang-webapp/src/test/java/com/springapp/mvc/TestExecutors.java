package com.springapp.mvc;


import com.springapp.model.Pp;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by songlinwei on 17/1/6.
 */
public class TestExecutors {
    // 最简单的使用方式
    private static final ExecutorService executorService_Fixed = Executors.newFixedThreadPool(4);
    private static final ExecutorService executorService_Cached = Executors.newCachedThreadPool();

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0l,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10000),
            new DefaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) {
        System.out.println("hello word");
        fThread();
//        fExecutors();
    }

    /**
     * 多线程实现卖票
     */
    private static void fThread() {
        Pp pp = new Pp();
        for (int fori = 0; fori < 4; fori++) {
            new Thread(pp).start();
        }
    }

    /**
     * 线程池实现卖票
     */
    private static void fExecutors() {
        try {
            Pp pp = new Pp();
            for (int fori = 0; fori < 4; fori++) {
                runExecutor(pp);
            }
        } finally {
            executorService_Fixed.shutdown();
            while (true) {
                if (executorService_Fixed.isTerminated()) {
                    break;
                }
                try {
                    Thread.sleep(500 * 2);
                } catch (InterruptedException e) {
                }
            }
        }
    }


    protected static void runExecutor(Pp pp) {
        executorService_Fixed.submit(new Thread(pp)

//                new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    if (tickets > 0) {
//                        System.out.println(Thread.currentThread().getName()+ "卖出了第" + (tickets--) + "张票");
//                        Thread.sleep(1000);
//                    }else {
//                        System.out.println(Thread.currentThread().getName()+ "卖完了");
//                    }
//                } catch (Exception e) {
//                }
//            }
//        }
        );
    }


    /**
     * The default thread factory
     */
    static class DefaultThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "songlinpool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}


