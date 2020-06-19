package ltd.ryantech.tree.kthLargest54;

import ltd.ryantech.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.kthLargest54
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 * @leetcode_CN_url // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/19 15:11
 **/

public class Solution3 {

    public int kthLargest(TreeNode root, int k) {
        int idx = 0;
        int res = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 向右走到底
            while (root != null) {
                stack.offerLast(root);
                root = root.right;
            }
            root = stack.pollLast();
            if (++idx == k) {
                return root.val;
            }
            // 处理左子树，只需要改变指针即可
            root = root.left;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(new Solution3().kthLargest(root, 3));
    }
}
