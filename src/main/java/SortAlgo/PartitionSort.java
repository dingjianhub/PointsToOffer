package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name sortAlgo
 * @description
 * @create 2020/09/23 22:23
 **/

public class PartitionSort {


    /**
     * 快速排序
     *
     * @param arr  待排序数组
     * @param low  待排序数组的最小 index
     * @param high 待排序数组的最大 index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }


    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 每次选取 pivot 选取最后一个元素
        int i = (low - 1); // 比 pivot 小的元素的下标，for 循环结束后，pivot 的位置是 i + 1
        int j;
        // j 从 low 开始向 high 进行遍历
        for (j = low; j < high; j++) {
            // 如果当前的元素小于 pivot
            if (arr[j] < pivot) {
                i++;
                // 交换 arr[i]  和 arr[j]
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        // 交换 arr[i + 1] 和 arr[high] (也就是 pivot)
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        quickSort(arr1, 0, 8);
        System.out.println("快速排序 " + Arrays.toString(arr1));
    }
}
