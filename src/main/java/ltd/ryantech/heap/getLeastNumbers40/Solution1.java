package ltd.ryantech.heap.getLeastNumbers40;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.heap
 * @description 面试题40. 最小的k个数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @hard_level Easy
 * @tag Heap // https://leetcode-cn.com/tag/heap/
 * @create 2020/06/17 14:25
 **/

public class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        /**
         * 使用小顶堆
         * 每个数都需要入 堆
         */
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        int[] res = new Solution1().getLeastNumbers(arr, 1);
        System.out.println(Arrays.toString(res));
    }
}
