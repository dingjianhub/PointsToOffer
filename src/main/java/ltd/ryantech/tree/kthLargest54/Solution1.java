package ltd.ryantech.tree.kthLargest54;

import ltd.ryantech.tree.TreeNode;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.kthLargest54
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 * @leetcode_CN_url // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/19 14:19
 **/

public class Solution1 {
    int nodeSum = 0;
    int m = 0;
    int mTh = 0;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        countNodeSum(root);
        mTh = nodeSum - k + 1;
        findMthNode(root);
        return res;
    }

    public void countNodeSum(TreeNode root) {
        if (root == null) {
            return;
        }
        countNodeSum(root.left);
        nodeSum++;
        countNodeSum(root.right);
    }

    public void findMthNode(TreeNode root) {
        if (root == null || m == mTh) {
            return;
        }
        findMthNode(root.left);
        m++;
        if (m == mTh) {
            res = root.val;
        }
        findMthNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(new Solution1().kthLargest(root, 1));
    }
}
