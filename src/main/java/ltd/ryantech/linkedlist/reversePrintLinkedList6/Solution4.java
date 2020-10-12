package ltd.ryantech.linkedlist.reversePrintLinkedList6;

import ltd.ryantech.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.reversePrintLinkedList6
 * @description 剑指 Offer 06. 从尾到头打印链表
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @hard_level Easy
 * @create 2020/10/12 10:59
 **/

public class Solution4 {
    // 引入额外的空间，递归的进行添加元素，最后进行反转
    List<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reverseAdd(head);
        int[] res = new int[tmp.size()];
        int idx = 0;
        for (int i : tmp) {
            res[idx++] = i;
        }
        return res;
    }

    private void reverseAdd(ListNode head) {
        if (head == null)
            return;
        reverseAdd(head.next);
        tmp.add(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        int[] res = new Solution4().reversePrint(head);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
