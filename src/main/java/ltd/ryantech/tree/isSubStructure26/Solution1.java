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
 * @create 2020/06/15 20:24
 **/

public class Solution1 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 任意一棵 树 为空，返回 false
        boolean res = false;

        if (A != null && B != null) {
            if (A.val == B.val) {
                res = isContainerSubtree(A, B);
            }

            if (!res) {
                res = isSubStructure(A.left, B);
            }

            if (!res) {
                res = isSubStructure(A.right, B);
            }
        }
        return res;
    }

    public boolean isContainerSubtree(TreeNode base, TreeNode sub) {
        // 这里判断 null 的先后是有原因的，只能允许 sub 为 null
        // 检索完 sub 子树，说明 base 中包含 sub 的子结构
        if (sub == null) {
            return true;
        }

        if (base == null) {
            return false;
        }

        if (base.val != sub.val) {
            return false;
        }

        return isContainerSubtree(base.left, sub.left) && isContainerSubtree(base.right, sub.right);
    }

    public static void main(String[] args) {
//        TreeNode base = new TreeNode(3);
//        base.left = new TreeNode(4);
//        base.right = new TreeNode(5);
//        base.left.left = new TreeNode(1);
//        base.left.right = new TreeNode(2);
//
//        TreeNode sub = new TreeNode(4);
//        sub.left = new TreeNode(1);
//
//        System.out.println(new Solution1().isSubStructure(base, sub));

        TreeNode base = new TreeNode(1);
        base.left = new TreeNode(2);
        base.right = new TreeNode(3);
        base.left.left = new TreeNode(4);

        TreeNode sub = new TreeNode(3);

        System.out.println(new Solution1().isSubStructure(base, sub));
    }
}
