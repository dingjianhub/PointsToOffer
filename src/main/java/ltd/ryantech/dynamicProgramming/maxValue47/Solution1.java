package ltd.ryantech.dynamicProgramming.maxValue47;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxValue47
 * @description 剑指 Offer 47. 礼物的最大价值
 * @leetcode_CN_url // https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/22 13:34
 **/

public class Solution1 {
    // 经典 dp[] 数组版本
    public int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (row == 0 && column == 0) {
                    dp[row][column] = grid[0][0]; // 初始化
                    continue;
                }
                if (row == 0) {
                    dp[row][column] = dp[row][column - 1] + grid[row][column];
                } else if (column == 0) {
                    dp[row][column] += dp[row - 1][column] + grid[row][column];
                } else {
                    dp[row][column] = Math.max(dp[row - 1][column], dp[row][column - 1]) + grid[row][column];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] gird = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution1().maxValue(gird));
    }
}
