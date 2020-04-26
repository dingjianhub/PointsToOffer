package ltd.ryantech.array.findNumberInMatrix;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findNumberInMatrix
 * @description 二维数组中的查找
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @hard_level Easy
 * @create 2020/04/26 14:46
 **/

public class Solution2 {
    // 相似题：Leftmost Column with at Least a One
    // https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

    // 从左下角开始 向下或向左 查找
    // 但是不能选取 左上角 和 右下角 的点
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] == target) {
                return true;
            } else if (target < matrix[row][column]) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 31;
        System.out.println(new Solution2().findNumberIn2DArray(matrix, target));
    }
}
