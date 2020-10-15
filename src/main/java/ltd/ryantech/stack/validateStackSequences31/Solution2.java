package ltd.ryantech.stack.validateStackSequences31;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.validateStackSequences31
 * @description 面试题31. 栈的压入、弹出序列
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @hard_level Medium
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 20:23
 **/

public class Solution2 {
    // 优化算法
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int idx = 0;
        for (int num : pushed) {
            stack.offerLast(num);
            while (!stack.isEmpty() && stack.peekLast() == popped[idx]) {
                stack.pollLast();
                idx++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};

//        int[] pushed = {2, 1, 0};
//        int[] popped = {1, 2, 0};
        boolean ans = new Solution2().validateStackSequences(pushed, popped);
        System.out.println(ans);
    }
}
