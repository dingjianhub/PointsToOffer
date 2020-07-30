package ltd.thread;

import org.junit.Test;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.thread
 * @description
 * @create 2020/07/26 17:59
 **/

public class Client5 {
    private int number = 0;
    private final Object lock = new Object();
    // 标志是否写入完成
    private boolean writeComplete = false;

    private void read() {
        synchronized (lock) {
            // 如果还没有写入完成，循环等待直到写入完成
            while (!writeComplete) {
                // 等待，并且不要阻塞写入
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("等待写入完成...");
            }
            System.out.println("number = " + number);
        }
    }

    private void write(int change) {
        synchronized (lock) {
            number += change;
            System.out.println("写入 " + number);
        }
    }

    @Test
    public void test() throws InterruptedException {
        // 开启一个线程写入 100 次 number
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                write(1);
            }
            writeComplete = true; // 标志位重置
            // 写入完成，唤醒读取线程，wait/notify 操作必须在 synchronized 中执行。
            synchronized (lock) {
                lock.notify();
            }
        }).start();

        // 开启一个线程读取 100 次 number
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                read();
            }
        }).start();

        // 睡眠一秒保证线程执行完成
        Thread.sleep(1000);
    }
}
