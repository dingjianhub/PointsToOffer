package ltd.ryantech.tree.pathSum34;

import ltd.ryantech.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.pathSum34
 * @description 面试题34. 二叉树中和为某一值的路径
 * @leetcode_CN_url // https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/16 23:17
 **/

public class Solution1 {
    private List<List<Integer>> lastRes = new LinkedList<>();
    private LinkedList<Integer> pathRes = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return lastRes;
    }

    public void dfs(TreeNode root, int target) {
        if (root != null) {
            pathRes.add(root.val);
            target = target - root.val;
            if (target == 0 && root.left == null && root.right == null) {
                lastRes.add(new LinkedList<>(pathRes)); // copy 一份，而不是选择 clear() 方法
                // 思考为什么不能 return ？
//                return;
            }
            dfs(root.left, target);
            dfs(root.right, target);
            // 回溯
            pathRes.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        List<List<Integer>> ans = new Solution1().pathSum(root, 22);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
