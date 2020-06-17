package ltd.ryantech.stack.minStack30;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.minStack30
 * @description 面试题30. 包含min函数的栈
 * @leetcode_CN_url // https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 13:43
 **/

/**
 * 定义 链表 节点 的结构
 */
class StackFrame {
    StackFrame next;
    int val;

    public StackFrame(int val) {
        this.val = val;
    }

    public StackFrame() {

    }
}


/**
 * 使用单链表实现栈
 * 插入和删除操作在 单链表 的头部进行，复杂度为 O(1)
 */
class MyLinkedListStack {
    StackFrame top;

    public MyLinkedListStack() {
        this.top = new StackFrame();
    }

    public int peek() {
        return this.top.val;
    }

    public void push(int val) {
        StackFrame newStackFrame = new StackFrame(val);
        newStackFrame.next = this.top; // 即使 此时 栈为空，也不会有异常
        top = newStackFrame;
    }

    public void pop() {
//        if (top == null) {
//            System.out.println("栈空，操作失败");
//            return;
//        }
        // 题目已经给定，在不空的情况下调用 pop() 方法
        this.top = this.top.next;
    }

    // 判定是否为空，这里需要判断的指针是 top.next
    // 初始化时，top.next 和 top 均为空
    // 所以判断是否为空需要判断 top.next 是否为空
    public boolean isEmpty() {
        return top.next == null;
    }
}

public class MyMinStack {
    private MyLinkedListStack stackValue;
    private MyLinkedListStack stackMin;

    public MyMinStack() {
        this.stackValue = new MyLinkedListStack();
        this.stackMin = new MyLinkedListStack();
    }

    public void push(int x) {
        if (this.stackValue.isEmpty() || this.stackMin.peek() >= x) {
            this.stackMin.push(x);
        }
        this.stackValue.push(x);
    }

    public void pop() {
        if (this.stackValue.peek() == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        this.stackValue.pop();
    }

    public int top() {
        return this.stackValue.peek();
    }

    public int min() {
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyMinStack MyMinStack = new MyMinStack();
        MyMinStack.push(2);
        MyMinStack.push(0);
        MyMinStack.push(3);
        MyMinStack.push(0);
        System.out.println(MyMinStack.min());
        MyMinStack.pop();
        System.out.println(MyMinStack.top());
    }
}
