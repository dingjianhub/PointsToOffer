package ltd.ryantech.heap.getLeastNumbers40;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.heap.getLeastNumbers40
 * @description 面试题40. 最小的k个数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @hard_level Easy
 * @tag Heap // https://leetcode-cn.com/tag/heap/
 * @create 2020/06/17 19:49
 **/

/**
 * 快速排序的切分思想
 * idx 的位置定位到 k 即可
 */
public class Solution4 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[]{};
        }

        return quickSearch(arr, 0, arr.length - 1, k - 1); // k - 1 注意，数组下标 0 开始
    }

    public int[] quickSearch(int[] arr, int low, int high, int k) {
        int idx = partition(arr, low, high);
        if (idx == k) {
            return Arrays.copyOf(arr, idx + 1);
        }
        return idx > k ? quickSearch(arr, low, idx - 1, k) : quickSearch(arr, idx + 1, high, k);
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选取最后一个元素作为 pivot 中枢
        int idx = low - 1; // 标记切分交换后的分界点
        int j, tmp;
        for (j = low; j < high; j++) {
            if (arr[j] < pivot) {
                idx++;
                tmp = arr[idx];
                arr[idx] = arr[j];
                arr[j] = tmp;
            }
        }

        // 交换 pivot 元素
        tmp = arr[idx + 1];
        arr[idx + 1] = arr[high];
        arr[high] = tmp;

        return idx + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        int[] res = new Solution4().getLeastNumbers(arr, 1);
        System.out.println(Arrays.toString(res));
    }
}
