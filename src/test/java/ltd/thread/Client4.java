package ltd.thread;

import org.junit.Test;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.thread
 * @description
 * @create 2020/07/26 17:54
 **/

/**
 * 更加常见的一个情况是，写入完成后，再读取值
 * 现在的问题在于现在读写方法都需要获取锁，一旦进入 read 函数，write 函数就必须等待，直到 read 函数释放锁。这会导致什么问题？”
 * write 函数在等待 read 函数，write 函数中的循环无法执行完，那么 writeComplete 就无法被置为 true，所以 read 函数就会无限循环。
 */
public class Client4 {
    private int number = 0;
    private final Object lock = new Object();
    // 标志是否写入完成
    private boolean writeComplete = false;

    private void read() {
        synchronized (lock) {
            // 如果还没有写入完成，循环等待直到写入完成
            while (!writeComplete) {
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
