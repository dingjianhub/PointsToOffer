package SortAlgo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/24 22:16
 **/

public class PartitionSortReview {
    /**
     * 快速排序
     *
     * @param arr  待排序数组
     * @param low  待排序数组的最小 index
     * @param high 待排序数组的最大 index
     */
    public static void quickSort(int[] arr, int low, int high) {
        // low 小于 high 的情况下，两分地调用 quickSort 来排序
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }


    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // 用于确定 pivot 最后的位置,for 循环结束后，pivot 的位置是 i + 1

        // j 从 low 开始向 high 进行遍历
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++; // i 向后移动，因为 i 位置已经有序了，需要把 i + 1 位置的元素和 arr[j] 进行交换
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        // 交换 arr[high] 和 arr[i + 1]
        // 即 将 pivot 元素写入到 arr[i + 1] 位置上去
        int tmp = arr[high];
        arr[high] = arr[i + 1];
        arr[i + 1] = tmp;

        return i + 1;
    }

    @Test
    public void testQuickSort() {
        int[] arr1 = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        quickSort(arr1, 0, 8);
        System.out.println("快速排序 " + Arrays.toString(arr1));
    }
}
