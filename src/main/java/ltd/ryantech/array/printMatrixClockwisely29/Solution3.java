package ltd.ryantech.array.printMatrixClockwisely29;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.printMatrixClockwisely29
 * @description 面试题29. 顺时针打印矩阵
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/05 14:21
 **/

public class Solution3 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int resSize = row * column;
        int[] ans = new int[resSize];
        boolean[][] visited = new boolean[row][column];
        int x = 0;
        int y = 0;
        int tot = 0;
        visited[x][y] = true;
        ans[tot] = matrix[x][y];

        while (tot < resSize - 1) {
            while (y + 1 < column && !visited[x][y + 1]) {
                ans[++tot] = matrix[x][++y];
                visited[x][y] = true;
            }
            while (x + 1 < row && !visited[x + 1][y]) {
                ans[++tot] = matrix[++x][y];
                visited[x][y] = true;
            }
            while (y - 1 >= 0 && !visited[x][y - 1]) {
                ans[++tot] = matrix[x][--y];
                visited[x][y] = true;
            }
            while (x - 1 >= 0 && !visited[x - 1][y]) {
                ans[++tot] = matrix[--x][y];
                visited[x][y] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {};
        int[] res = new Solution3().spiralOrder(matrix);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
