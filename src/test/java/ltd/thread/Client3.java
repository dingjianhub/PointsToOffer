package ltd.thread;

import org.junit.Test;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.thread
 * @description
 * @create 2020/07/26 17:48
 **/

public class Client3 {
    private int number = 0;
    private final Object lock = new Object();

    private void read() {
        synchronized (lock) {
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
