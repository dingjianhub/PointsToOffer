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
 * @create 2020/06/15 16:29
 **/

public class Solution1 {
    // 迭代法
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        ListNode tmp = null;
        // 若 head 为 null 则跳过 while 循环，返回 cur = null
        while (pre != null) {
            tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Solution1().reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
