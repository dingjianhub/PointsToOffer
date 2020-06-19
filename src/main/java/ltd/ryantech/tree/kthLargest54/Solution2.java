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
 * @create 2020/06/19 14:53
 **/

public class Solution2 {
    int idx = 0;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null || idx == k) {
            // 提前结束
            return;
        }
        // 先右
        dfs(root.right, k);
        if (++idx == k) {
            res = root.val;
        }
        // 后左
        dfs(root.left, k);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(new Solution2().kthLargest(root, 1));
    }
}
