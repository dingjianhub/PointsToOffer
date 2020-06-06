package ltd.ryantech.array.printMatrixClockwisely29;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.printMatrixClockwisely29
 * @description 面试题29. 顺时针打印矩阵
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/05 11:30
 **/

public class Solution2 {
    // 如果给定的输入数组中的数据都是正数的话，可以修改原数组来节约空间
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int resSize = row * column;
        int[] ans = new int[resSize];
        int x = 0;
        int y = 0;
        int tot = 0;
        while (tot < resSize) {
            while (y < column && matrix[x][y] != -1) {
                ans[tot++] = matrix[x][y];
                matrix[x][y] = -1;
                y++;
            }
            y--; // 修正
            x++; // 换到下一行
            while (x < row && matrix[x][y] != -1) {
                ans[tot++] = matrix[x][y];
                matrix[x][y] = -1;
                x++;
            }
            x--; // 修正
            y--; // 换行
            while (y >= 0 && matrix[x][y] != -1) {
                ans[tot++] = matrix[x][y];
                matrix[x][y] = -1;
                y--;
            }
            y++; // 修正
            x--; // 换行
            while (x >= 0 && matrix[x][y] != -1) {
                ans[tot++] = matrix[x][y];
                matrix[x][y] = -1;
                x--;
            }
            x++; // 修正
            y++; // 换行
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {};
        int[] res = new Solution2().spiralOrder(matrix);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
