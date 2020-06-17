package ltd.ryantech.stack.minStack30;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.minStack30
 * @description 面试题30. 包含min函数的栈
 * @leetcode_CN_url // https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 13:23
 **/

public class Solution1 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
