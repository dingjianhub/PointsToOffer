package ltd.ryantech.stack.minStack30;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.stack.minStack30
 * @description 面试题30. 包含min函数的栈
 * @leetcode_CN_url // https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 15:13
 **/

class ArrayStack {
    private int[] items;
    private int size = 0;
    private int usedSize = 0;

    public ArrayStack(int size) {
        this.size = size;
        this.items = new int[size];
    }

    public ArrayStack() {
        this.size = 8;
        this.items = new int[8];
    }

    // 支持动态扩容的 顺序栈
    public void push(int val) {
        if (this.usedSize < this.size) {
            this.items[usedSize] = val;
            usedSize++;
        } else {
            int[] newItems = new int[this.size * 2];
            if (this.size >= 0) System.arraycopy(this.items, 0, newItems, 0, this.size);
            this.size = newItems.length;
            newItems[usedSize++] = val;
            this.items = newItems;
        }
    }

    public void pop() {
        if (this.usedSize == 0) {
            System.out.println("栈空，执行操作失败");
            return;
        }
        this.usedSize--;
    }

    public int peek() {
        if (this.usedSize != 0) {
            return this.items[usedSize - 1];
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }
}

public class MyMinArrayStack {
    private ArrayStack stackValue;
    private ArrayStack stackMin;

    public MyMinArrayStack() {
        this.stackValue = new ArrayStack();
        this.stackMin = new ArrayStack();
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

    public int getMin() {
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyMinArrayStack myMinArrayStack = new MyMinArrayStack();
        myMinArrayStack.push(-2);
        myMinArrayStack.push(0);
        myMinArrayStack.push(3);
        System.out.println(myMinArrayStack.getMin());
        myMinArrayStack.pop();
        System.out.println(myMinArrayStack.top());
        System.out.println(myMinArrayStack.getMin());
    }
}
