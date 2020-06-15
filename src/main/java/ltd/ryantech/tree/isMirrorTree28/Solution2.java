package ltd.ryantech.tree.isMirrorTree28;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.isMirrorTree28
 * @description 面试题28. 对称的二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @hard_level Easy
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/15 23:24
 **/

public class Solution2 {
    // 非递归算法
    // 使用队列辅助，类似 BFS 思想
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 访问到根节点的情况下
            if (left == null && right == null) {
                continue;
            }
            // 出现了不对称残缺，非镜像
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(new Solution2().isSymmetric(root));
    }
}
