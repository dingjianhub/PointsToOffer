package SortAlgo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/26 09:33
 **/

public class MergeSortReview {

    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int ln = mid - low + 1;
        int rn = high - mid;

        int L[] = new int[ln];
        int R[] = new int[rn];

        // 数组的复制
        for (int t = 0; t < ln; t++) {
            L[t] = arr[low + t];
        }
        for (int t = 0; t < rn; t++) {
            R[t] = arr[t + mid + 1];
        }


        int i = 0, j = 0;
        int p = low; // 注意此处的 p 为每次 merge 的起始位置
        while (i < ln && j < rn) {
            if (L[i] < R[j]) {
                arr[p] = L[i];
                i++;
            } else {
                arr[p] = R[j];
                j++;
            }
            p++;
        }

        while (i < ln) {
            arr[p] = L[i];
            i++;
            p++;
        }
        while (j < rn) {
            arr[p] = R[j];
            j++;
            p++;
        }
    }

    @Test
    public void testMergeSort() {
        int[] res = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        mergeSort(res, 0, 8);
        System.out.println(Arrays.toString(res));
    }
}
