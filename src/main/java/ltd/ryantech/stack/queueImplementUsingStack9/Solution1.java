package ltd.ryantech.stack.queueImplementUsingStack9;

import java.util.Stack;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.queueImplementUsingStack9
 * @description 用两个栈实现队列
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @hard_level Easy
 * @create 2020/05/01 20:29
 **/

public class Solution1 {
    Stack<Integer> stack_in;
    Stack<Integer> stack_out;

    public Solution1() {
        this.stack_in = new Stack<>();
        this.stack_out = new Stack<>();
    }

    public void appendTail(int value) {
        this.stack_in.push(value);
    }

    public int deleteHead() {
        if (this.stack_out.isEmpty()) {
            if (this.stack_in.isEmpty()) {
                // 均为空时，说明队列为空
                return -1;
            }
            while (!this.stack_in.isEmpty()) {
                // 当 out 为空时，将 in 的数据全部弹出并压入到 out 中去
                this.stack_out.push(this.stack_in.pop());
            }
            return this.stack_out.pop(); // in 数据完全压入 out 后，再弹出 out 顶部元素
        }
        return this.stack_out.pop();
    }

    public static void main(String[] args) {
        Solution1 queueDemo = new Solution1();
        queueDemo.appendTail(1);
        queueDemo.appendTail(2);
        queueDemo.appendTail(3);
        queueDemo.appendTail(4);
        System.out.println(queueDemo.deleteHead());
        System.out.println(queueDemo.deleteHead());
    }
}
