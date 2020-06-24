package ltd.ryantech.dynamicProgramming.maxValue47;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxValue47
 * @description 剑指 Offer 47. 礼物的最大价值
 * @leetcode_CN_url // https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/22 13:52
 **/

public class Solution2 {
    // 利用 grid 数组，优化空间
    // 但是改变了输入的数组
    public int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (row == 0 && column == 0) {
                    continue;
                }
                if (row == 0) {
                    grid[row][column] += grid[row][column - 1];
                } else if (column == 0) {
                    grid[row][column] += grid[row - 1][column];
                } else {
                    grid[row][column] += Math.max(grid[row - 1][column], grid[row][column - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] gird = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution2().maxValue(gird));
    }
}
