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

    private int length = 0;

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            length++;
        }
        // 结束循环时 ，cur 为空指针，pre 为新的头部
        return pre;
    }

    public int[] reversePrint(ListNode head) {
        ListNode tmp = reverseList(head);
        int[] res = new int[length];
        int idx = 0;
        while (tmp != null) {
            res[idx++] = tmp.val;
            tmp = tmp.next;
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
