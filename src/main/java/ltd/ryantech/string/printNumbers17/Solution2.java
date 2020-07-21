package ltd.ryantech.string.printNumbers17;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.string.printNumbers17
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/07/21 21:14
 **/

class Node {
    int val;
    int pos;
    Node next;

    public Node(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}

public class Solution2 {

    public void printNumbersToN(int n) {
        if (n <= 0) {
            return;
        }

        Node head = new Node(0, 1);
        for (int i = 0; i < n - 1; i++) {
            head.next = new Node(0, i + 2);
        }

        while (!Increment(head)) {
            printNumber(head);
        }
    }

    public boolean Increment(Node head) {
        return false;
    }

    public void printNumber(Node head) {

    }

    public static void main(String[] args) {

    }
}
