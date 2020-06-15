package ltd.ryantech.tree.maxDepth55;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.maxDepth55
 * @description 面试题55 - I. 二叉树的深度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/15 21:30
 **/

public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int ans = new Solution1().maxDepth(root);
        System.out.print(ans);
    }
}
