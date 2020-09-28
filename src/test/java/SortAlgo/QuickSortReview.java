package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/27 17:02
 **/

public class QuickSortReview {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 每次选取最后一个元素作为 pivot
        int i = low - 1;// 比 pivot 小的元素的下标
        int j; // 遍历数组，最远到 high - 1
        for (j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;

        return i + 1;
    }

    public boolean verifySort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] res = new int[2000];
        int resLength = res.length;
        int k = 100;
        int pos = 0;
        for (int i = 0; i < resLength; i++) {
            res[i] = (int) (Math.random() * resLength) % resLength;
        }
        QuickSortReview quickSortReview = new QuickSortReview();
        quickSortReview.quickSort(res, 0, resLength - 1);
        for (int i = 0; i < k; i++) {
            int t = resLength / k;
            int[] tmp = new int[t];
            for (int j = 0; j < t; j++) {
                tmp[j] = res[pos++];
            }
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println(quickSortReview.verifySort(res));
    }
}
