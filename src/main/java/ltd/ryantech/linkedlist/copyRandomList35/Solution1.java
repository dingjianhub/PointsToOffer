package ltd.ryantech.linkedlist.copyRandomList35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.copyRandomList35
 * @description 面试题35. 复杂链表的复制
 * @leetcode_CN_url // https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @hard_level Medium
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/06/17 10:18
 **/

public class Solution1 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> randomMap = new HashMap<>();
        Node headCursor = head;
        while (headCursor != null) {
            randomMap.put(headCursor, new Node(headCursor.val));
            headCursor = headCursor.next;
        }
        // 注意这里的操作，是遍历 原始链表，因为 HashMap 不保证数据的有序性
        headCursor = head;
        while (headCursor != null) {
            randomMap.get(headCursor).next = randomMap.get(headCursor.next);
            randomMap.get(headCursor).random = randomMap.get(headCursor.random);
            headCursor = headCursor.next;
        }
        return randomMap.get(head);
    }

    public static void main(String[] args) {

    }
}
