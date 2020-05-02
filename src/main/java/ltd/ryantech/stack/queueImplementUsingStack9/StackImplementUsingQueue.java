package ltd.ryantech.stack.queueImplementUsingStack9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.queueImplementUsingStack9
 * @description 用 2 个队列实现 1 个栈
 * @create 2020/05/01 21:29
 **/

public class StackImplementUsingQueue {
    Queue<Integer> queue_in;
    Queue<Integer> queue_out;

    public StackImplementUsingQueue() {
        this.queue_in = new LinkedList<>();
        this.queue_out = new LinkedList<>();
    }

    public void pushToStack(int value) {
        this.queue_in.add(value);
    }

    public int popFromStack() {
        if (this.queue_out.isEmpty()) {
            if (this.queue_in.isEmpty()) {
                // 2 个 queue 均空时，表示栈空，返回 -1
                return -1;
            }
            while (this.queue_in.size() != 1) {
                // 当 in 队列还有最后一个尾部元素时，将其余元素转移至 out 中
                // 相当于将”栈顶元素“挤到 in 的头元素位置
                // 最后删除 in 的头元素，即完成了“弹栈”操作
                this.queue_out.add(this.queue_in.remove());
            }
            return this.queue_in.remove();
        } else {
            // 当 out 中存在元素时，需要将 out 中的元素入队到 in 中
            // 将 out 的队尾，即“栈顶元素”挤到 out 的头元素位置
            // 再将 out 头元素出队，即完成了”弹栈“操作
            while (this.queue_out.size() != 1) {
                this.queue_in.add(this.queue_out.remove());
            }
            return this.queue_out.remove();
        }
    }

    public static void main(String[] args) {
        StackImplementUsingQueue stack = new StackImplementUsingQueue();
        stack.pushToStack(1);
        stack.pushToStack(2);
        stack.pushToStack(3);
        stack.pushToStack(4);
        System.out.println(stack.popFromStack());
        System.out.println(stack.popFromStack());
        stack.pushToStack(5);
        stack.pushToStack(6);
        System.out.println(stack.popFromStack());
        System.out.println(stack.popFromStack());
        stack.pushToStack(7);
        System.out.println(stack.popFromStack());
        System.out.println(stack.popFromStack());
        System.out.println(stack.popFromStack());
        System.out.println(stack.popFromStack());
        System.out.println(stack.popFromStack());
    }
}
