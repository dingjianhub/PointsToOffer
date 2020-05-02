package ltd.ryantech.recursive.frogStairs10;

import ltd.ryantech.recursive.fibonacci10.Solution2;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.recursive.frogStairs10
 * @description 青蛙跳台阶的问题
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @hard_level Easy
 * @create 2020/05/02 19:57
 **/

public class Solution1 {
    // 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
    public int numWays(int n) {
        if (n < 0) {
            return -1;
        }

        int[] res = {1, 1};
        if (n < 2) {
            return res[n];
        }

        int fibOne = 1;
        int fibTwo = 1;
        int fibSum = 0;
        for (int i = 2; i <= n; i++) {
            fibSum = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibSum;
        }
        return fibSum;
    }

    public static void main(String[] args) {
        int n = 4;
        int sum = new Solution1().numWays(n);
        System.out.println(sum);
    }
}
