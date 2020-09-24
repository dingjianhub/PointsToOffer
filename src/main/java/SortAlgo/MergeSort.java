package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name sortAlgo
 * @description
 * @create 2020/09/23 21:39
 **/

public class MergeSort {
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


    public static void main(String[] args) {
        int[] res1 = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        mergeSort(res1, 0, 8);
        System.out.println("归并排序 升序排序 " + Arrays.toString(res1));
    }
}
