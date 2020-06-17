package ltd.ryantech.heap.getLeastNumbers40;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.heap
 * @description 面试题40. 最小的k个数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @hard_level Easy
 * @tag Heap // https://leetcode-cn.com/tag/heap/
 * @create 2020/06/17 14:32
 **/

public class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        /**
         * 利用大顶堆
         * 每次将大数从 堆顶 弹出，将小的数字保留下来
         */
        if (k == 0 || arr == null || arr.length == 0) {
            return new int[]{};
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        int[] res = new Solution2().getLeastNumbers(arr, 1);
        System.out.println(Arrays.toString(res));
    }
}
