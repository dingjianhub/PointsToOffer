package ltd.ryantech.linkedlist.FindKthToTail22;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.FindKthToTail22
 * @description 面试题22. 链表中倒数第k个节点
 * @leetcode_CN_url // https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/06/14 14:58
 **/

public class Solution1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (count < k && fast != null) {
            fast = fast.next;
            count++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = new Solution1().getKthFromEnd(head, 2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
