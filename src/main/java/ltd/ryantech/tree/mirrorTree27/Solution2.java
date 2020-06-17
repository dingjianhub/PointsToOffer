package ltd.ryantech.tree.mirrorTree27;

import ltd.ryantech.linkedlist.copyRandomList35.Node;
import ltd.ryantech.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.mirrorTree27
 * @description 面试题27. 二叉树的镜像
 * @leetcode_CN_url // https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/17 17:56
 **/

public class Solution2 {
    // 利用 栈 交换 root 的 左右子节点
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pollLast();
            TreeNode cur = stack.pollFirst();
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode ans = new Solution2().mirrorTree(root);
        System.out.print("MirrorTree");
    }
}
