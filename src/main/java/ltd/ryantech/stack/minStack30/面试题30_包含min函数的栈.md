# 面试题 30 ：包含min函数的栈

---

[leetcode-cn 题目地址](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

📗difficulty： **Easy**

🎯Tags：

+ **[链表](https://leetcode-cn.com/tag/linked-list/)**
+ **[数组](https://leetcode-cn.com/tag/array/)**
+ **[栈](https://leetcode-cn.com/tag/stack/)** 
+ **[设计](https://leetcode-cn.com/tag/design/)** 
---

## 1. 题目描述📃

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 `O(1)`。



**样例 1 ：**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```



**提示：**

+ 各函数的调用总次数不超过 20000 次



**注意：**

+ 本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/



---

## 2. 解题思路💡

### 思路分析

面对抽象的操作，使用一个具体的例子来分析题目，再构建操作模型，是一个很好的手段。

![《剑指 Offer》中给的 Tips](https://assets.ryantech.ltd/20200617154724.png)



如果有一个栈来模拟真实的操作，那么实现 `push` 、`peek`、`top` 的操作非常简单，因为这就是栈的操作。需要考虑的地方在 `getMin` 操作上。

可以设置一个数据结构来存放最小值，每次可以在 O(1) 时间内获取到最小值。如果使用栈来操作，复杂度是可以满足的。但是如何去界定存取逻辑呢？

+ 如果一个数据要被压入 数据栈 `stackValue` ，它的值比当前的 `getMin` 要小，那么就把这个数字同步压入 辅助栈 `stackMin` 中去，否则不压入。
+ 如果一个数据要被弹出 数据栈 `stackValue`，那么就看下这个数是不是和  辅助栈 `stackMin` 的栈顶一样，如果一样，同步弹出，否则会造成“`getMin` 的最小值不在 数据栈 `stackValue` 中的错误”。

至此，将情况分为了 2 类，覆盖率全部的可能性，可以编写代码了。



---

> 虽然可以使用内建的类实现，但是面试官更加希望面试者自己手写一个栈。
>
> 可以选择使用数组实现，也可以选择 链表实现栈。
>
> 使用数组，需要考虑栈的扩容操作；使用链表的话，选择单链表，需要一点点的小技巧。
>
> 请在本题尝试使用 自己手写 的方法，完成 面试题 30。



#### 使用内建的类来操作

使用 `Deque` 和 `LinkedList` 来实现 `Stack` 的操作。在没有特殊要求的情况下，优先选择内建类。



##### 代码实现

```java
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
```



##### 复杂度分析

+ 时间复杂度：`O(n)` 。
+ 空间复杂度：`O(2n)` 。



---

#### 使用 链表 来 实现一个栈

这里使用单向链表来实现一个栈，这里需要一点点的技巧，对链表的插入和删除操作均在链表头进行，可以将复杂度下降到 `O(1)`，符合题目要求。

转而同时考察了 链表的 删改操作。对于链表的操作，需要格外注意空指针的问题，需要做到精准判断。



##### 代码实现

```java
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

```



##### 复杂度分析

+ 时间复杂度：`O(n)` 。
+ 空间复杂度：`O(2n)` 。



---

#### 使用 数组 实现一个 顺序栈

顺序栈需要考虑到数组的扩容操作，其优点在于节约内存。

一般情况下，顺序栈的操作复杂度都是 O(1) ，但是在扩容的时候，需要涉及到数组的搬迁，其复杂度会上升到 O(n)，但是只有那么一次，平均下来，其复杂度也是 O(1)。



##### 代码实现

```java
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

```



##### 复杂度分析

+ 时间复杂度：`O(n)` 。使用 平均复杂度 来衡量 顺序栈 的时间复杂度的情况下。
+ 空间复杂度：`O(2n)` 。



---

## 3. 总结🎯

可以把这道题看成是一道普通的关于栈的题目，也可以当作是一道关于栈的设计题，需要手工实现自己的栈。

自己实现，考察了对 数组 和 链表 的熟悉程度，和对栈的掌握情况，是一个更加可能的考察方向。

### 相似题目

[面试题09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

