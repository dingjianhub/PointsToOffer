package SortAlgo;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/26 14:08
 **/

public class MergeThread implements Runnable {
    public int[] arr;

    public MergeThread(int[] arr) {
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
        Scanner input = new Scanner(System.in);
        int resLength = input.nextInt();
        int[] res = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            int number = ((int) (Math.random() * resLength) % resLength);
            res[i] = number;
        }

        int mid = resLength / 2;
        MergeThread mergeThread = new MergeThread(res);

        Timestamp now = new Timestamp(System.currentTimeMillis());
        System.out.println(now);

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

        System.out.println("归并排序 升序排序 " + Arrays.toString(res));
        System.out.println(mergeThread.verifySort(res));

        Timestamp now1 = new Timestamp(System.currentTimeMillis());
        System.out.println(now1);
    }
}
