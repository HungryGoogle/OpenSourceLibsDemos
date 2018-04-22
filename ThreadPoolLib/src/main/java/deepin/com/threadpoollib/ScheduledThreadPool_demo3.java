package deepin.com.threadpoollib;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool_demo3 {
    public static void main(String[] args) {
        ScheduledExecutorService cachedThreadPool = Executors.newScheduledThreadPool(5);
        // 测试1个线程
        for (int i = 0; i < 1; i++) {
            final int index = i;

            // 1秒后开始执行，每3秒执行1次
            cachedThreadPool.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": delay 1 seconds, and excute every 3 seconds " + index);
                }
            }, 1, 3, TimeUnit.SECONDS);
        }
    }
}
