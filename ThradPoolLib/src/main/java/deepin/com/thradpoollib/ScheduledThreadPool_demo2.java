package deepin.com.thradpoollib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool_demo2 {
    public static void main(String[] args) {
        ScheduledExecutorService cachedThreadPool = Executors.newScheduledThreadPool(5);
        // 测试1个线程
        for (int i = 0; i < 1; i++) {
            final int index = i;

            // 3秒后开始执行
            cachedThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": begin index = " + index);

                    try {
                        Thread.sleep(index * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": end index = " + index);
                }
            }, 3, TimeUnit.SECONDS);
        }
    }
}
