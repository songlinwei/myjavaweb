package com.springapp.model;

import java.util.Random;

/**
 * Created by songlinwei on 17/1/9.
 */
public class Pp implements Runnable {
    private int countP = 50;

    public void ppp() {
        while (countP > 0) {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (countP > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t当前票号：" + countP);
                    countP--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t票已经卖完了");
                }
            }
        }
    }

    @Override
    public void run() {
        ppp();
    }

}
