package SortAlgo;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name sortAlgo
 * @description
 * @create 2020/09/23 14:59
 **/

public class SelectSort {

    /**
     * <p>
     * 选择排序（Selection Sort）的基本思想是不断地从数组当中未排序的部分选取关键字最小的记录，
     * 并将该记录作为已排序部分的最后一个记录（考虑升序排列的情况）。
     * 算法主要就是维护一个给定数组的两个子数组：
     * 数组已排序的部分；
     * 数组未排序的部分；
     * 在选择排序的每一次迭代中，从数组中未排序的部分选择出最小元素（升序排列的情况），然后将其移入数组已排序的部分。
     * </p>
     *
     * <p>
     * 当前的算法下，该选择排序是不稳定的。
     * 问题出在了 选择 元素的算法上
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组长度
     * @return 排序后有序的数组
     */
    public static int[] selectSort(int[] arr, int length) {
        int i, j;
        int minIdx;

        // 一共需要排序 length - 1 次
        for (i = 0; i < length - 1; i++) {
            minIdx = i;
            for (j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 将元素进行交换
            // 有序部分长度加 1 ， 无序部分长度减 1
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }


    /**
     * <p>
     * 选择排序（Selection Sort）的基本思想是不断地从数组当中未排序的部分选取关键字最小的记录，
     * 并将该记录作为已排序部分的最后一个记录（考虑升序排列的情况）。
     * 算法主要就是维护一个给定数组的两个子数组：
     * 数组已排序的部分；
     * 数组未排序的部分；
     * 在选择排序的每一次迭代中，从数组中未排序的部分选择出最小元素（升序排列的情况），然后将其移入数组已排序的部分。
     * </p>
     *
     * <p>
     * 当前的算法下，改动了选择部分的算法，使得该排序是稳定的
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组长度
     * @return 排序后有序的数组
     */
    public static int[] selectSortStable(int[] arr, int length) {
        int i, j;
        int minIdx;

        // 一共需要排序 length - 1 次
        for (i = 0; i < length - 1; i++) {
            minIdx = i;
            for (j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 将最小的元素记录下来
            int key = arr[minIdx];
            // 将从 i 到 min - 1 的元素都向后移动一个位置
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }
            // 将最小的元素值，写到有序部分的末尾
            arr[i] = key;
        }
        return arr;
    }


    /**
     * <p>
     * 选择排序（Selection Sort）的基本思想是不断地从数组当中未排序的部分选取关键字最小的记录，
     * 并将该记录作为已排序部分的最后一个记录（考虑升序排列的情况）。
     * 算法主要就是维护一个给定数组的两个子数组：
     * 数组已排序的部分；
     * 数组未排序的部分；
     * 在选择排序的每一次迭代中，从数组中未排序的部分选择出最小元素（升序排列的情况），然后将其移入数组已排序的部分。
     * </p>
     *
     * <p>
     * 当前的算法下，该选择排序是不稳定的。
     * 问题出在了 选择 元素的算法上
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组长度
     * @return 排序后有序的数组
     */
    public static String[] selectSortString(String[] arr, int length) {
        int i, j;
        int minIdx;

        // 一共需要排序 length - 1 次
        for (i = 0; i < length - 1; i++) {
            minIdx = i;
            for (j = i + 1; j < length; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            // 将元素进行交换
            // 有序部分长度加 1 ， 无序部分长度减 1
            String tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    /**
     * <p>
     * 选择排序（Selection Sort）的基本思想是不断地从数组当中未排序的部分选取关键字最小的记录，
     * 并将该记录作为已排序部分的最后一个记录（考虑升序排列的情况）。
     * 算法主要就是维护一个给定数组的两个子数组：
     * 数组已排序的部分；
     * 数组未排序的部分；
     * 在选择排序的每一次迭代中，从数组中未排序的部分选择出最小元素（升序排列的情况），然后将其移入数组已排序的部分。
     * </p>
     *
     * <p>
     * 当前的算法下，改动了选择部分的算法，使得该排序是稳定的
     * </p>
     *
     * @param arr    待排序数组
     * @param length 待排序数组长度
     * @return 排序后有序的数组
     */
    public static String[] selectSortStingStable(String[] arr, int length) {
        int i, j;
        int minIdx;

        // 一共需要排序 length - 1 次
        for (i = 0; i < length - 1; i++) {
            minIdx = i;
            for (j = i + 1; j < length; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            // 将最小的元素记录下来
            String key = arr[minIdx];
            // 将从 i 到 min - 1 的元素都向后移动一个位置
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }
            // 将最小的元素值，写到有序部分的末尾
            arr[i] = key;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] res1 = selectSort(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("选择排序 升序排序 " + Arrays.toString(res1));

        int[] res2 = selectSortStable(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("选择排序 升序排序 " + Arrays.toString(res2));

        String[] res3 = selectSortStingStable(new String[]{"paper", "true", "soap", "floppy", "flower"}, 5);
        System.out.println("字符串 数组 选择排序 稳定版 升序排序 " + Arrays.toString(res3));

        String[] res4 = selectSortString(new String[]{"paper", "true", "soap", "floppy", "flower"}, 5);
        System.out.println("字符串 数组 选择排序 不稳定版 升序排序 " + Arrays.toString(res4));
    }
}
