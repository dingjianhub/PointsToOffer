package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name sortAlgo
 * @description
 * @create 2020/09/23 15:56
 **/


public class InsertSort {
    /**
     * <p>
     * 入排序简单的就像玩扑克牌（双Q，斗地主)。
     * 基本操作就是将一个记录插入到已排好序的有序表中，直到将所有的未排序记录插入到适当的位置。
     * </p>
     *
     * <p>
     * 插入排序是稳定性排序
     * 插入排序稳定的根本原因是，
     * 待插入的元素不会插入到与自身值相同的关键字之前，
     * 所以排序前后值相同的关键字的相对顺序被保留了下来。
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组的长度
     * @return 排序后的有序数组
     */
    public static int[] insertionSort(int[] arr, int length) {
        int i, j;
        int key;

        for (i = 1; i < length; i++) {
            key = arr[i];  // 当前要插入正确洞的记录
            j = i - 1;  // key 可插入的最右边界
            // 在 0 到 i-1 中找到 key 应该放入的正确洞
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }


    /**
     * <p>
     * 两分插入排序
     * </p>
     *
     * <p>
     * 对插入关键字的范围查找，使用 两分查找 算法
     * 可以将查找的复杂度降低到 O(n)
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组的长度
     * @return 排序后的有序数组
     */
    public static int[] insertionSortBinary(int[] arr, int length) {
        int i, j;
        int key;
        int loc;

        for (i = 1; i < length; i++) {
            key = arr[i];  // 当前要插入正确洞的记录
            j = i - 1;  // key 可插入的最右边界
            // 在 0 到 i-1 中找到 key 应该放入的正确洞
            loc = binarySearch(arr, key);
            while (j >= loc) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }


    /**
     * <p>
     * 插入排序 递归版本
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组的长度
     * @return 排序后的有序数组
     */
    public static int[] insertionSortRecursion(int[] arr, int length) {
        // 递归结束的条件
        if (length <= 1) {
            return arr;
        }

        // 递归调用
        insertionSortRecursion(arr, length - 1);

        int key = arr[length - 1];
        int j = length - 2;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        return arr;
    }


    /**
     * <p>
     * 使用 排除法 思路的 两分查找
     * </p>
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        if (arr.length == 0) {
            return 0;
        } else if (arr[arr.length - 1] < key) {
            return arr.length;
        }

        int left = 0;
        int right = arr.length - 1;
        // 循环结束时 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 严格小于 target 的元素一定不是解
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    /**
     * <p>
     * 交换法 实现插入排序
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组的长度
     * @return 排序后的有序数组
     */
    public static int[] insertionSortSwap(int[] arr, int length) {
        int i, j;
        for (i = 1; i < length; i++) {
            j = i;
            // 将 arr[i] 插入到 arr[0,j - 1] 的正确位置
            while (j > 0 && arr[j] < arr[j - 1]) {
                // 交换
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        return arr;
    }


    /**
     * <p>
     * 交换法 实现插入排序
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组的长度
     * @return 排序后的有序数组
     */
    public static int[] insertionSortSwapRecursion(int[] arr, int length) {
        if (length <= 1) {
            return arr;
        }

        insertionSortRecursion(arr, length - 1);
        int j = length - 1;
        // 将 arr[i] 插入到 arr[0,j - 1] 的正确位置
        while (j > 0 && arr[j] < arr[j - 1]) {
            // 交换
            int tmp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = tmp;
            j--;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] res1 = insertionSort(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 升序排序 " + Arrays.toString(res1));


        int[] res2 = insertionSortBinary(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 两分优化 升序排序 " + Arrays.toString(res2));

        int[] res3 = insertionSortRecursion(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 递归调用 升序排序 " + Arrays.toString(res3));

        int[] res4 = insertionSortSwap(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 交换法 升序排序 " + Arrays.toString(res4));


        int[] res5 = insertionSortSwapRecursion(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 交换法 递归实现 升序排序 " + Arrays.toString(res5));

    }
}
