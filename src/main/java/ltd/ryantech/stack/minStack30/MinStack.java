package ltd.ryantech.stack.minStack30;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.minStack30
 * @description 面试题30. 包含min函数的栈
 * @leetcode_CN_url // https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 13:21
 **/

public class MinStack {

    /**
     * initialize your data structure here.
     */

    private Deque<Integer> stackValue;
    private Deque<Integer> stackMin;

    public MinStack() {
        this.stackValue = new LinkedList<>();
        this.stackMin = new LinkedList<>();
    }

    public void push(int x) {
        if (this.stackValue.isEmpty() || this.stackMin.peekLast() >= x) {
            this.stackMin.offerLast(x);
        }
        this.stackValue.offerLast(x);
    }

    public void pop() {
        if (this.stackValue.peekLast().equals(this.stackMin.peekLast())) {
            this.stackMin.pollLast();
        }
        this.stackValue.pollLast();
    }

    public int top() {
        return this.stackValue.peekLast();
    }

    public int min() {
        return this.stackMin.peekLast();
    }
}
