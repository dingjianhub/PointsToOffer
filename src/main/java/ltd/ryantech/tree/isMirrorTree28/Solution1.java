package ltd.ryantech.tree.isMirrorTree28;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.isMirrorTree28
 * @description 面试题28. 对称的二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/15 22:42
 **/

public class Solution1 {
    // 递归解法
    // 思想类似于 DFS 深度优先搜索
    // 沿着左子树的左子树走到底部，同时沿着右子树的右子树走到底部，每次比较其底部的值，再递归向上。
    // 然后沿着左子树的右子树，沿着右子树的左子树走到底部，进行比较，逐层向上递归，每次比较其值。
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // 根节点的情况，其值相同
        if (t1 == null && t2 == null) {
            return true;
        }
        // 出现了不对称残缺，非镜像
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean ans = new Solution1().isSymmetric(root);
        System.out.println(ans);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        boolean ans1 = new Solution1().isSymmetric(root1);
        System.out.println(ans1);
    }
}
