package ltd.ryantech.dynamicProgramming.wayOfMartix12;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.wayOfMartix12
 * @description 删除链表的节点  其中保证链表中的每个元素 val 不相同
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/05/05 18:33
 **/

public class Solution1 {
    public boolean exist(char[][] board, String word) {
        // word 为空串，直接返回 false
        if (word == null || word.length() == 0) {
            return false;
        }

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从左上角位置开始搜索
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // index 越界; 矩阵当前元素和字符串元素不匹配; 返回 false
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || board[i][j] != word[k]) {
            return false;
        }
        // 已经完成了全部元素的匹配，存在该路径
        if (k == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        // 这里可能出现错误，需要保证 board 中的元素均不为 '/'；才可以是的程序正确
        board[i][j] = '/';
        // dfs 顺序为 下 上 右 左
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Solution1().exist(board, word));
    }
}
