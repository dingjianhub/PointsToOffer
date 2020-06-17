package ltd.ryantech.linkedlist.copyRandomList35;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.copyRandomList35
 * @description 面试题35. 复杂链表的复制
 * @leetcode_CN_url // https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/06/17 10:56
 **/

public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        cloneList(head);
        randomDirect(head);
        return reList(head);
    }

    public void cloneList(Node head) {
        Node cursor = head;
        while (cursor != null) {
            Node cloneCursor = new Node(cursor.val); // 新建一个节点
            Node tmp = cursor.next; // 做一个暂存
            cloneCursor.next = cursor.next; // 首先将 新节点 的尾部连接起来
            cursor.next = cloneCursor; // 再将 新节点 插入到 链表中去
            cursor = tmp; // 更新 cursor 的值
        }
    }

    public void randomDirect(Node head) {
        Node cursor = head;
        while (cursor != null) {
            // 克隆链表的 游标 起始位置是 cursor.next
            Node cloneCursor = cursor.next;
            if (cursor.random != null) {
                // random 指向的节点
                Node directNode = cursor.random;
                // 克隆是按序克隆的，克隆节点的 random 是 directNode 的 next
                cloneCursor.random = directNode.next;
            }
            // 注意这里的 cursor 指针更新为 cloneCursor.next
            cursor = cloneCursor.next;
        }
    }

    public Node reList(Node head) {
        Node cursor = head;
        // 克隆好的节点的头部是 head.next
        Node cloneHead = head.next;
        // 克隆链表的 游标指针
        Node cloneCursor = head.next;
        /**
         * 下面两行代码是一个 难点
         * 是为了将 cloneHead 从链表中分离出来
         */
        cursor.next = cloneCursor.next;
        cursor = cursor.next; // 此时 cursor 已经指向了“第二个”节点，且 cloneHead 已经分离
        while (cursor != null) {
            cloneCursor.next = cursor.next; // clone 节点位于 “源节点” 后一个
            cursor.next = cursor.next.next; // 分离 clone 节点
            cursor = cursor.next; // 移动到下一个 “源节点”
            cloneCursor = cloneCursor.next; // 移动 cloneCursor 指针到 cloneHead 链表尾部
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node tmpPrev = head;
        Node node2 = head.next = new Node(2);
        node2.random = tmpPrev;
        Node tmpPrev2 = node2.next = new Node(3);
        Node node4 = node2.next.next = new Node(4);
        node4.random = tmpPrev2;
        Node cloneHead = new Solution2().copyRandomList(head);
        System.out.println("stop");
    }
}
