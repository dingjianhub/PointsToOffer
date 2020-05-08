package ltd.ryantech.deepFirstSearch.robotMovingCount13;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.deepFirstSearch.robotMovingCount13
 * @description 机器人的运动范围
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 深度优先搜索 // https://leetcode-cn.com/tag/depth-first-search/
 * @create 2020/05/08 11:07
 **/

public class Solution1 {
    // 未优化版本，可优化搜索方向
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        return dfs(this.visited, 0, 0, k);
    }

    public int dfs(boolean[][] visited, int row, int column, int k) {
        if (row < 0 || row >= visited.length ||
                column < 0 || column >= visited[0].length ||
                visited[row][column]) {
            return 0;
        }
        if (getDigital(row, column) <= k) {
            visited[row][column] = true;
            int base = 1;
            // dfs 方向为 下 上 左 右
            int area = dfs(visited, row - 1, column, k) +
                    dfs(visited, row + 1, column, k) +
                    dfs(visited, row, column - 1, k) +
                    dfs(visited, row, column + 1, k);
            return base + area;
        } else {
            visited[row][column] = true;
            return 0;
        }
    }

    public int getDigital(int row, int column) {
        int res = 0;
        while (row > 0) {
            res += row % 10;
            row = row / 10;
        }
        while (column > 0) {
            res += column % 10;
            column = column / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().movingCount(16, 8, 4));
    }
}
