package ltd.ryantech.heap.getLeastNumbers40;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.heap
 * @description 面试题40. 最小的k个数
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @hard_level Easy
 * @tag Heap // https://leetcode-cn.com/tag/heap/
 * @create 2020/06/17 14:46
 **/

public class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        /**
         * 二叉搜索树 O(N log K)
         */
        if (k == 0 || arr == null || arr.length == 0) {
            return new int[]{};
        }

        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            // 1. 遍历数组，若当前map中的数字个数小于 k，则map中当前数字对应个数 +1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }

            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数 -1。
            Map.Entry<Integer, Integer> entry = map.lastEntry(); // 默认返回最大 key
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[idx++] = entry.getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        int[] res = new Solution3().getLeastNumbers(arr, 1);
        System.out.println(Arrays.toString(res));
    }
}
