package ltd.ryantech.tree.isBalanced55;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.isBalanced55
 * @description 面试题55 - II. 平衡二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/19 15:48
 **/

public class Solution1 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtree = dfs(root.left);
        if (leftSubtree == -1) {
            return -1;
        }
        int rightSubtree = dfs(root.right);
        if (rightSubtree == -1) {
            return -1;
        }
        return Math.abs(leftSubtree - rightSubtree) <= 1 ? Math.max(leftSubtree, rightSubtree) + 1 : -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(new Solution1().isBalanced(root));
    }
}
