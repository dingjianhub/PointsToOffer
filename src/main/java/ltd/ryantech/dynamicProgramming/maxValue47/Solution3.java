package ltd.ryantech.dynamicProgramming.maxValue47;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxValue47
 * @description 剑指 Offer 47. 礼物的最大价值
 * @leetcode_CN_url // https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/22 13:56
 **/

public class Solution3 {
    // 初始化 0 行 0 列，避免多次冗余判断
    public int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        // 初始化第 0 行
        for (int row = 1; row < m; row++) {
            grid[row][0] += grid[row - 1][0];
        }
        // 初始化第 0 列
        for (int column = 1; column < n; column++) {
            grid[0][column] += grid[0][column - 1];
        }

        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                grid[row][column] += Math.max(grid[row - 1][column], grid[row][column - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] gird = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution3().maxValue(gird));
    }
}
