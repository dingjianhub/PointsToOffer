package ltd.ryantech.linkedlist.deleteNode;

import ltd.ryantech.linkedlist.ListNode;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.deleteNode
 * @description 删除链表的节点 其中保证链表中的每个元素 val 不相同
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @hard_level Easy
 * @create 2020/04/26 19:33
 **/

public class Solution1 {
    // 从链表头部开始遍历，定位到删除节点的前一个节点，执行“删除”操作
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode newHead = dummyHead;
        while (newHead.next != null) {
            if (newHead.next.val == val) {
                newHead.next = newHead.next.next;
                return dummyHead.next;
            }
            newHead = newHead.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        int target = 9;
        ListNode resHead = new Solution1().deleteNode(head, target);
        while (resHead != null) {
            System.out.println(resHead.val);
            resHead = resHead.next;
        }
    }
}
