package SortAlgo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/24 19:40
 **/

public class SelectSortReview {
    /**
     * 选择排序
     *
     * @param arr    需要排序的数组
     * @param length 需要排序的数组的长度
     * @return 排序后有序的数组
     */
    public int[] selectSort(int[] arr, int length) {
        int key;
        int i, j;
        // 需要选择 length - 1 次
        for (i = 0; i < length - 1; i++) {
            key = i;
            // 注意 j 的起始位置选择
            for (j = i + 1; j < length; j++) {
                if (arr[j] < arr[key]) {
                    key = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[key];
            arr[key] = tmp;
        }
        return arr;
    }

    @Test
    public void testSelectSort() {
        int[] arr = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        int[] res = selectSort(arr, arr.length);
        System.out.println(Arrays.toString(res));
    }

    /*--------------------------------------------------------------------------------*/

    /**
     * 选择排序
     * 顺序稳定版本
     *
     * @param arr    需要排序的数组
     * @param length 需要排序的数组的长度
     * @return 排序后有序的数组
     */
    public int[] selectSortStable(int[] arr, int length) {
        int minIdx;
        int i, j;
        // 需要选择 length - 1 次
        for (i = 0; i < length - 1; i++) {
            minIdx = i;
            // 注意 j 的起始位置选择
            for (j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int key = arr[minIdx];
            // 将 i 到 minIdx - 1 的数据进行搬迁
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }
            // 将最小的元素值，写到有序部分的末尾
            arr[i] = key;
        }
        return arr;
    }

    @Test
    public void testSelectSortStable() {
        int[] arr = new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9};
        int[] res = selectSortStable(arr, arr.length);
        System.out.println(Arrays.toString(res));
    }

    /*-------------------------------------------------------------------------------------*/

    /**
     * 选择排序
     * 顺序稳定版本
     *
     * @param arr    需要排序的数组
     * @param length 需要排序的数组的长度
     * @return 排序后有序的数组
     */
    public String[] selectSortStringStable(String[] arr, int length) {
        int minIdx;
        int i, j;
        // 需要选择 length - 1 次
        for (i = 0; i < length - 1; i++) {
            minIdx = i;
            for (j = i + 1; j < length; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }

            String key = arr[minIdx];
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }
            arr[i] = key;
        }
        return arr;
    }

    @Test
    public void testSelectSortStringStable() {
        String[] arr = new String[]{"paper", "true", "soap", "floppy", "flower"};
        String[] res = selectSortStringStable(arr, arr.length);
        System.out.println(Arrays.toString(res));
    }
}
