package SortAlgo;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name SortAlgo
 * @description
 * @create 2020/09/24 20:47
 **/

public class InsertSortReview {
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
    public int[] insertionSort(int[] arr, int length) {
        int key; // 每次要插入的 key
        int i, j;
        // 要把 从 1 ~ length - 1 的数据进行一一插入
        for (i = 1; i < length; i++) {
            key = arr[i];
            j = i - 1; // 有序数组的最右边界
            // 开始在 0 ~ j 间寻找位置并且插入
            while (j >= 0 && key < arr[j]) {
                // 移动数据
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    @Test
    public void testInsertionSort() {
        int[] res = insertionSort(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 升序排序 " + Arrays.toString(res));
    }

    /*-----------------------------------------------------------------------------*/

    /**
     * 递归实现
     * 插入排序
     *
     * @param arr
     * @param length
     * @return
     */
    public int[] insertionSortRecursion(int[] arr, int length) {
        // 递归结束的条件
        if (length == 1) {
            return arr;
        }

        insertionSortRecursion(arr, length - 1);

        int key = arr[length - 1]; // 递归结束，此时最后一个元素是需要插入的元素
        int j = length - 2; // 有序边界是 key 位置 index - 1
        while (j >= 0 && key < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;

        return arr;
    }

    @Test
    public void testInsertionSortRecursion() {
        int[] res = insertionSortRecursion(new int[]{3, 1, 2, 4, 5, 6, 7, 8, 9}, 9);
        System.out.println("插入排序 递归实现 升序排序 " + Arrays.toString(res));
    }

}
