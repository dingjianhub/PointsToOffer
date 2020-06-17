package ltd.ryantech.linkedlist.copyRandomList35;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.linkedlist.copyRandomList35
 * @description
 * @create 2020/06/17 10:19
 **/

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
