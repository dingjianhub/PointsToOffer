package ltd.ryantech.linkedlist.reversePrintLinkedList6;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.reversePrintLinkedList6
 * @description 剑指 Offer 06. 从尾到头打印链表
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @hard_level Easy
 * @create 2020/08/26 12:23
 **/

public class Solution3 {

    int nodeCount = 0;

    private int[] reversePrint(ListNode head) {
        ListNode cursor = reverseListHelper(head);
        int[] res = new int[nodeCount + 1];
        int idx = 0;
        while (cursor != null) {
            res[idx++] = cursor.val;
            cursor = cursor.next;
        }
        return res;
    }

    private ListNode reverseListHelper(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmp = reverseListHelper(head.next);
        nodeCount++; // 注意最后的结果为 链表长度 - 1
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        int[] res = new Solution3().reversePrint(head);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
