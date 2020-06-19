package ltd.ryantech.tree.isBalanced55;

import ltd.ryantech.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.isBalanced55
 * @description 面试题55 - II. 平衡二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/19 18:43
 **/

public class Solution3 {
    // 存在大量的重复计算 depth
    // 额外使用一个 HashMap 来避免重复计算
    Map<TreeNode, Integer> map = new HashMap<>();

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
        if (map.containsKey(root)) {
            return map.get(root);
        } else {
            int curDepth = Math.max(depth(root.left), depth(root.right)) + 1;
            map.put(root, curDepth);
            return curDepth;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(new Solution3().isBalanced(root));
    }
}
