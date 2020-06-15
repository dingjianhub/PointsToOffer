package ltd.ryantech.linkedlist.reverseList24;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.reverseList24
 * @description 面试题24. 反转链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/06/15 16:50
 **/

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head; // 绕回来了
        head.next = null; // 断开指针，防止循环
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Solution2().reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
