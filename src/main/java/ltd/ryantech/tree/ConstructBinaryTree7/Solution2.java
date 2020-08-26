package ltd.ryantech.tree.ConstructBinaryTree7;

import java.util.HashMap;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.ConstructBinaryTree7
 * @description 剑指 Offer 07. 重建二叉树
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @hard_level Medium
 * @create 2020/08/26 14:04
 **/

public class Solution2 {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]);
        int i = indexMap.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }

    public void preorderTraverse(TreeNode root) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        System.out.println(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution2 tree = new Solution2();
        TreeNode root = tree.buildTree(preorder, inorder);
        tree.preorderTraverse(root);
    }
}
