package ltd.ryantech.linkedlist.mergeTwoLists25;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.mergeTwoLists25
 * @description 面试题25. 合并两个排序的链表
 * @leetcode_CN_url // https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @hard_level Easy
 * @tag Linked List // https://leetcode-cn.com/tag/linked-list/
 * @create 2020/06/14 16:42
 **/

public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(-1);
        ListNode cursor = res;
        while (p1 != null && p2 != null) {
            if (p2.val >= p1.val) {
                cursor.next = p1;
                p1 = p1.next;
            } else {
                cursor.next = p2;
                p2 = p2.next;
            }
            cursor = cursor.next;
        }

        // 处理其中还有链表存在剩余的情况
//        while (p1 != null) {
//            cursor.next = p1;
//            p1 = p1.next;
//            cursor = cursor.next;
//        }
//        while (p2 != null) {
//            cursor.next = p2;
//            p2 = p2.next;
//            cursor = cursor.next;
//        }
        cursor.next = (p1 != null ? p1 : p2);
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new Solution1().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
