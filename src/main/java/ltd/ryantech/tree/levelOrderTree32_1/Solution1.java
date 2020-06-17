package ltd.ryantech.tree.levelOrderTree32_1;

import ltd.ryantech.tree.TreeNode;

import java.util.*;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.levelOrderTree32
 * @description 面试题32 - I. 从上到下打印二叉树
 * @leetcode_CN_url // https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/16 20:33
 **/

public class Solution1 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (deque.peekFirst() != null) {
            TreeNode cur = deque.pollFirst();
            if (cur != null) {
                res.add(cur.val);
                if (cur.left != null) {
                    deque.offerLast(cur.left);
                }

                if (cur.right != null) {
                    deque.offerLast(cur.right);
                }
            }
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for (int num : res) {
            ans[idx++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int[] res = new Solution1().levelOrder(root);
        System.out.println(Arrays.toString(res));
    }
}
