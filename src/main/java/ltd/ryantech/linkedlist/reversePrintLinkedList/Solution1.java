package ltd.ryantech.linkedlist.reversePrintLinkedList;

import ltd.ryantech.linkedlist.ListNode;

import java.util.Stack;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.reversePrintLinkedList
 * @description 逆序打印链表
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @hard_level Easy
 * @create 2020/04/26 18:28
 **/

public class Solution1 {
    // 具有明显的 "后进先出" 特性，使用 栈 来辅助操作
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode newHead = head;
        Stack<ListNode> stack = new Stack<>();
        while (newHead != null) {
            stack.push(newHead);
            newHead = newHead.next;
        }
        int[] res = new int[stack.size()];
        int p = 0;
        while (!stack.isEmpty()) {
            res[p] = stack.pop().val;
            p++;
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
