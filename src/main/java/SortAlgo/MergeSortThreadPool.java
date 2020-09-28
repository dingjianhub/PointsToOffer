package SortAlgo;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/26 15:00
 **/

public class MergeSortThreadPool implements Runnable {
    /**
     * 线程池的核心线程数量
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     * 线程池的最大线程数
     */
    private static final int MAX_POOL_SIZE = 10;

    /**
     * 任务队列，用来储存等待执行任务的队列
     */
    private static final int QUEUE_CAPACITY = 100;

    /**
     * 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
     */
    private static final Long KEEP_ALIVE_TIME = 1L;

    public int[] arr;

    public MergeSortThreadPool(int[] arr) {
        this.arr = arr;
    }

    /**
     * @param arr   待排序数组
     * @param left  待排序数组最左的 index
     * @param right 待排序数组最右的 index
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 合并有序的 2 部分
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int length1 = mid - left + 1;
        int length2 = right - mid;

        int[] L = new int[length1];
        int[] R = new int[length2];

        // 拷贝数组
        for (int i = 0; i < length1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < length2; ++j) {
            R[j] = arr[mid + j + 1];
        }

        // 合并数据
        int l1 = 0, r1 = 0;
        int idx = left;
        // 任意一个走到底，就退出循环
        while (l1 < length1 && r1 < length2) {
            if (L[l1] <= R[r1]) {
                arr[idx] = L[l1++];
            } else {
                arr[idx] = R[r1++];
            }
            idx++;
        }

        while (l1 < length1) {
            arr[idx] = L[l1];
            l1++;
            idx++;
        }

        while (r1 < length2) {
            arr[idx] = R[r1];
            r1++;
            idx++;
        }
    }


    @Override
    public void run() {

    }


    /**
     * 验证排序是否成功
     *
     * @param arr
     * @return
     */
    public boolean verifySort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println(arr[i] + " : " + arr[i + 1]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        int resLength = 2000;
        int[] res = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            int number = ((int) (Math.random() * resLength) % resLength);
            res[i] = number;
        }

        int mid = resLength / 2;
        MergeSortThreadPool mergeSortThreadPool = new MergeSortThreadPool(res);

        Timestamp now = new Timestamp(System.currentTimeMillis());
        System.out.println(now);

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Thread thread1 = new Thread(() -> {
            mergeSort(res, 0, mid);
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            mergeSort(res, mid + 1, resLength - 1);
        });
        thread2.start();

        thread1.join();
        thread2.join();

        merge(res, 0, mid, resLength - 1);

        System.out.println("归并排序 升序排序 , 数量 : " + resLength);
        System.out.println(Arrays.toString(res));
        System.out.println(mergeSortThreadPool.verifySort(res));

        Timestamp now1 = new Timestamp(System.currentTimeMillis());
        System.out.println(now1);
        System.out.println(Instant.now());
    }
}
