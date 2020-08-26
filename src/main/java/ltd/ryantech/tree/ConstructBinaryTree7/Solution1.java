package ltd.ryantech.tree.ConstructBinaryTree7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.ConstructBinaryTree7
 * @description 剑指 Offer 07. 重建二叉树
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @hard_level Medium
 * @create 2020/05/01 11:25
 **/

public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length; // 树中的节点数量与遍历方式无关
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1,
                inorder, 0, length - 1,
                indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                              int[] inorder, int inorderStart, int inorderEnd,
                              Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            // 递归结束情形 1 : 先序遍历的开始范围大于结束范围，此时表示二叉树中没有节点
            return null;
        }

        int rootVal = preorder[preorderStart]; // 先序遍历的情况下，第一个 index 处为根节点
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            // 递归结束情形 2 : 开始等于结束，意味着当前二叉树中只有一个节点，以该节点值创建根节点并返回
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            // 左右子树的构建
            // 注意先序和中序的下标位置
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                    inorder, inorderStart, rootIndex - 1,
                    indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd,
                    indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
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
        Solution1 tree = new Solution1();
        TreeNode root = tree.buildTree(preorder, inorder);
        tree.preorderTraverse(root);
    }
}
