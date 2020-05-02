package ltd.ryantech.linkedlist.reversePrintLinkedList6;

import ltd.ryantech.linkedlist.ListNode;

import java.util.Stack;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.reversePrintLinkedList6
 * @description 从尾到头打印链表
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @hard_level Easy
 * @create 2020/05/02 10:52
 **/

public class Solution2 {
    // 在可以修改指针的情况下，将指针进行反转，实现从头到尾的打印节点
    // 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode cur = null;
        ListNode pre = head;
        ListNode t = null;
        int nodesCounter = 0;
        while (pre != null) {
            t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
            nodesCounter++;
        }

        int[] res = new int[nodesCounter];
        ListNode p = cur;
        int i = 0;
        while (p != null) {
            res[i++] = p.val;
            p = p.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        int[] res = new Solution1().reversePrint(head);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
