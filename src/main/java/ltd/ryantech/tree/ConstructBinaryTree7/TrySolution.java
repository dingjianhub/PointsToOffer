package ltd.ryantech.tree.ConstructBinaryTree7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.ConstructBinaryTree7
 * @description
 * @create 2020/05/01 17:37
 **/

public class TrySolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode tree = buildTree(preorder, 0, length - 1,
                inorder, 0, length - 1,
                indexMap);
        return tree;
    }

    public TreeNode buildTree(int[] preorder, int preoderStart, int preorderEnd,
                              int[] inorder, int inorderStart, int inorderEnd,
                              Map<Integer, Integer> indexMap) {
        if (preoderStart > preorderEnd) {
            return null;
        }

        int rootValue = preorder[preoderStart];
        TreeNode root = new TreeNode(rootValue);
        if (preoderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootValue);
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
//            TreeNode leftSubtree = buildTree(preorder, preoderStart + 1, preoderStart + leftNodes,
//                    inorder, inorderStart, rootIndex - 1,
//                    indexMap);
            TreeNode leftSubtree = buildTree(preorder, preoderStart + 1, preoderStart + leftNodes,
                    inorder, inorderStart, inorderStart + leftNodes - 1,
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
        TrySolution tree = new TrySolution();
        TreeNode root = tree.buildTree(preorder, inorder);
        tree.preorderTraverse(root);
    }
}
