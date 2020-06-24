package ltd.ryantech.queue.maxSlidingWindow59_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.queue.maxSlidingWindow59_1
 * @description 剑指 Offer 59 - I. 滑动窗口的最大值
 * @leetcode_CN_url // https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @hard_level Easy
 * @tag Queue // https://leetcode-cn.com/tag/queue/
 * @create 2020/06/23 18:44
 **/

public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxInWindows = new LinkedList<>();

        if (nums.length >= k && k >= 1) {
            // index 存储的是 nums 数组中元素的下标
            Deque<Integer> index = new LinkedList<>();

            // 初步建立滑动窗口
            for (int i = 0; i < k; i++) {
                // index 不为空 且 窗口最右边的数字 nums[i] 比它前面的数字都要大的话，就依次从队尾删除元素
                // 保证了队列的头部元素最大
                while (!index.isEmpty() && nums[i] > nums[index.peekLast()]) {
                    index.pollLast();
                }
                // 将 num[i] 的下标存入队列中
                // 此时，队列 index 中下标对应元素是非严格递减的
                // 队列头部元素下标 i 对应的 nums[i] 最大
                index.offerLast(i);
            }

            // 大小为 k 的滑动窗口建立完成，继续处理
            for (int i = k; i < nums.length; i++) {
                // 窗口的最大值数组 存入 当前 index 队列的头部下标
                maxInWindows.offerLast(nums[index.peekFirst()]);

                while (!index.isEmpty() && nums[i] >= nums[index.peekLast()]) {
                    index.pollLast();
                }
                // 如果队列头部的数字已经从其中滑出，那么滑出的数字也需要从队列的头部删除
                if (!index.isEmpty() && index.peekFirst() <= (i - k)) {
                    index.pollFirst();
                }
                index.offerLast(i);
            }
            maxInWindows.offerLast(nums[index.peekFirst()]);
        }
        int[] res = new int[maxInWindows.size()];
        int idx = 0;
        for (int num : maxInWindows) {
            res[idx++] = num;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = new Solution1().maxSlidingWindow(nums, 3);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
