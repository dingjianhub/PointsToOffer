package ltd.ryantech.array.findNumberInMatrix4;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findNumberInMatrix
 * @description 二维数组中的查找
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @hard_level Easy
 * @create 2020/04/26 14:52
 **/

public class Solution3 {
    // 相似题：Leftmost Column with at Least a One
    // https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

    // 二分查找法
    // 对每一行的数进行一次 两分查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int mid;
        int low, high;
        for (int row = 0; row < matrix.length; row++) {
            low = 0;
            high = matrix[0].length - 1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (target < matrix[row][mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
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
        System.out.println(new Solution3().findNumberIn2DArray(matrix, target));
    }
}
