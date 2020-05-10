package ltd.ryantech.dynamicProgramming.cuttingRope14;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.cuttingRope14
 * @description 剪绳子
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/ ,贪心算法
 * @create 2020/05/10 11:26
 **/

public class Solution2 {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0; // 题目中给定 n >= 2
        }
        if (n == 2) {
            return 1; // 给定最少剪成 2 段，那么只能剪成 1 * 1 的形式
        }
        if (n == 3) {
            return 2; // 可以剪成 1 * 1 * 1 和 1 * 2 的形式，最大值为 2
        }

        int maxRes = 0;
        int timeOf3 = n / 3;
        if (n % 3 == 0) { // 全部切为 3 没有剩余
            maxRes = (int) Math.pow(3, timeOf3);
        } else if (n % 3 == 1) {
            maxRes = (int) Math.pow(3, timeOf3 - 1) * 4; // 剩余长度为 1，那么借一个 3，切分为 2 * 2
        } else {
            maxRes = (int) Math.pow(3, timeOf3) * 2; // 剩余长度为 2
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution2().cuttingRope(n));
    }
}
