package ltd.ryantech.tree.levelOrderTree32_3;

import ltd.ryantech.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.levelOrderTree32_3
 * @description 面试题32 - III. 从上到下打印二叉树 III
 * @leetcode_CN_url // https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/16 21:48
 **/

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lastRes = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offerLast(root);
        }
        while (!deque.isEmpty()) {
            // 奇数层 从左到右
            List<Integer> levelRes = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode cur = deque.pollFirst();
                if (cur != null) {
                    levelRes.add(cur.val);
                    // 奇数层，存储顺序是 从右到左
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                }
            }
            lastRes.add(levelRes);
            if (deque.isEmpty()) {
                break;
            }

            levelRes = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode cur = deque.pollLast();
                if (cur != null) {
                    levelRes.add(cur.val);
                    // 偶数层，从右到左 存储
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
            }
            lastRes.add(levelRes);
        }
        return lastRes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new Solution1().levelOrder(root);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
