package ltd.ryantech.tree.isSubStructure26;

import ltd.ryantech.tree.TreeNode;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.isSubStructure26
 * @description 面试题26. 树的子结构
 * @leetcode_CN_url // https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/15 21:03
 **/

public class Solution2 {
    // 思路二：比较值的操作在 recur 时一并判断
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode base = new TreeNode(1);
        base.left = new TreeNode(2);
        base.right = new TreeNode(3);
        base.left.left = new TreeNode(4);

        TreeNode sub = new TreeNode(3);

        System.out.println(new Solution2().isSubStructure(base, sub));
    }
}
