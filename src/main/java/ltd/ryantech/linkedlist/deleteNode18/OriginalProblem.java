package ltd.ryantech.linkedlist.deleteNode18;

import ltd.ryantech.linkedlist.ListNode;


/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.deleteNode18
 * @description 在 O(1) 时间内删除链表的节点
 * @create 2020/05/02 15:26
 **/

public class OriginalProblem {
    public ListNode deleteNode(ListNode head, ListNode target) {
        if (head == null) {
            return null;
        }

        if (target.next != null) {
            // 需要删除的节点不是尾节点
            target.val = target.next.val; // 覆写
            target.next = target.next.next; // 修改指针
        } else if (target == head) {
            // 链表中只有一个节点的情况，此时需要被删除的节点是 头节点，也是 尾节点
            head = null;
        } else {
            // 需要删除的节点是 尾节点
            ListNode p = head;
            while (p.next != target) {
                p = p.next;
            }
            p.next = p.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode target;
        ListNode head = new ListNode(4);
        target = head;
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
//        target = head.next.next.next = new ListNode(9);
        ListNode resHead = new OriginalProblem().deleteNode(head, target);
        while (resHead != null) {
            System.out.println(resHead.val);
            resHead = resHead.next;
        }
    }
}
