package ltd.ryantech.tree.treeToDoublyList36;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.treeToDoublyList36
 * @description 定义二叉搜索树的节点 Node
 * @create 2020/08/25 09:55
 **/

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
