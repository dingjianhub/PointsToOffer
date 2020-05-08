package ltd.ryantech.deepFirstSearch.robotMovingCount13;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.deepFirstSearch.robotMovingCount13
 * @description 机器人的运动范围
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 深度优先搜索 // https://leetcode-cn.com/tag/depth-first-search/
 * @create 2020/05/08 15:17
 **/

public class Solution2 {
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        return dfs(this.visited, 0, 0, k);  // 注意此处参数，从[0,0]位置开始搜索
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
            // dfs 方向为 下 右
            int area = dfs(visited, row + 1, column, k) +
                    dfs(visited, row, column + 1, k);
            return base + area;
        } else {
            return 0;  // 不满足数位和即返回 false
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
        System.out.println(new Solution2().movingCount(16, 8, 4));
    }
}
