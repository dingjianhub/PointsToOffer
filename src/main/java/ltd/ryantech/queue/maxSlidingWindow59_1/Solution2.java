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
 * @create 2020/06/23 19:32
 **/

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] maxInWindows = new int[nums.length - k + 1];
        // slideWindow 存储的是 非严格递减 的序列
        Deque<Integer> slideWindow = new LinkedList<>();

        // 初步建立滑动窗口
        for (int i = 0; i < k; i++) {
            // slideWindow 不为空 且 窗口最右边的数字 nums[i] 比它前面的数字都要大的话，就依次从队尾删除元素
            // 保证了队列的头部元素最大
            while (!slideWindow.isEmpty() && nums[i] > slideWindow.peekLast()) {
                slideWindow.pollLast();
            }
            // 将 nums[i] 存入队列中
            // 此时，队列 slideWindow 中元素是非严格递减的
            // 队列头部元素值最大
            slideWindow.offerLast(nums[i]);
        }
        // 大小为 k 的滑动窗口建立完成，继续处理
        // 窗口的最大值存入最终的数组
        maxInWindows[0] = slideWindow.peekFirst();

        for (int i = k; i < nums.length; i++) {
            // 如果队列头部的数字已经从其中滑出，那么滑出的数字也需要从队列的头部删除
            // 例如 nums.length = 8,k = 3 的情况。for 循环第一轮，如果当前最大值为 nums[0] 需要删除它，因为已经滑过去了
            if (!slideWindow.isEmpty() && slideWindow.peekFirst() == nums[i - k]) {
                slideWindow.pollFirst();
            }
            // 这里的判断是严格大于，如果不是严格判断，会造成数据误删除
            // 因为上面对元素是否出队进行了判断
            while (!slideWindow.isEmpty() && nums[i] > slideWindow.peekLast()) {
                slideWindow.pollLast();
            }
            slideWindow.offerLast(nums[i]);
            maxInWindows[i - k + 1] = slideWindow.peekFirst();
        }
        return maxInWindows;
    }


    public static void main(String[] args) {
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int[] res = new Solution2().maxSlidingWindow(nums, 4);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
