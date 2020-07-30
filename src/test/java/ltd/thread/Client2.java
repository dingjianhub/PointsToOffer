package ltd.thread;

import org.junit.Test;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.thread
 * @description
 * @create 2020/07/26 17:42
 **/

/**
 * 通过对 write 方法加上 synchronized 关键字，解决了写入的竞争问题
 */
public class Client2 {
    private int number = 0;
    private final Object lock = new Object();

    private void read() {
        System.out.println("number = " + number);
    }

    private void write(int change) {
        synchronized (lock) {
            number += change;
        }
    }


    @Test
    public void test() throws InterruptedException {
        // 开启一个线程加 10000 次
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                write(1);
            }
            System.out.println("增加 10000 次已完成");
        }).start();

        // 开启一个线程减 10000 次
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                write(-1);
            }
            System.out.println("减少 10000 次已完成");
        }).start();

        // 睡眠一秒保证线程执行完成
        Thread.sleep(1000);
        // 读取结果
        read();
    }
}
