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
 * @create 2020/06/19 16:38
 **/

public class Solution2 {
    // 存在大量的重复计算 depth
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 对每棵子树递归检查是否平衡
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 获取树的最大深度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(new Solution2().isBalanced(root));
    }
}
