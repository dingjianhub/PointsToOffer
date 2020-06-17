package ltd.ryantech.tree.verifyPostorder33;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.tree.verifyPostorder33
 * @description 面试题33. 二叉搜索树的后序遍历序列
 * @leetcode_CN_url // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @hard_level Medium
 * @tag Tree // https://leetcode-cn.com/tag/tree/
 * @create 2020/06/16 23:08
 **/

public class Solution1 {
    public boolean verifyPostorder(int[] postorder) {
        return true;
    }

    public boolean handler(int[] postorder, int left, int right) {
        return false;
    }

    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        boolean ans = new Solution1().verifyPostorder(postorder);
        System.out.println(ans);
    }
}
