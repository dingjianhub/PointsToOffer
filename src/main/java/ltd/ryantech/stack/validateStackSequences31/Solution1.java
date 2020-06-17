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
 * @create 2020/06/16 19:24
 **/

/**
 * 自主思考的思路
 * 不够完美，及格线
 */
public class Solution1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> pushedStack = new LinkedList<>();
        Deque<Integer> poppedStack = new LinkedList<>();
        for (int i = 0; i < popped.length; i++) {
            poppedStack.offerLast(popped[i]);
        }
        int idx = 0;
        // 题目给定了 pushed.length == popped.length
        while (idx < pushed.length) {
            pushedStack.offerFirst(pushed[idx]);
            idx++;
            while (!pushedStack.isEmpty() && pushedStack.peekFirst().equals(poppedStack.peekFirst())) {
                pushedStack.pollFirst();
                poppedStack.pollFirst();
            }
        }
        while (!poppedStack.isEmpty()) {
            if (poppedStack.peekFirst().equals(pushedStack.peekFirst())) {
                poppedStack.pollFirst();
                pushedStack.pollFirst();
            } else {
                poppedStack.pollFirst();
            }
        }
        return pushedStack.isEmpty();
    }

    public static void main(String[] args) {
//        int[] pushed = {1, 2, 3, 4, 5};
//        int[] popped = {4, 5, 3, 2, 1};

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};

//        int[] pushed = {2, 1, 0};
//        int[] popped = {1, 2, 0};
        boolean ans = new Solution1().validateStackSequences(pushed, popped);
        System.out.println(ans);
    }
}
