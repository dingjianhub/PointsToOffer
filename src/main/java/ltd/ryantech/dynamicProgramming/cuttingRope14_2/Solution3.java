package ltd.ryantech.dynamicProgramming.cuttingRope14_2;

import java.math.BigInteger;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.cuttingRope14_2
 * @description 剑指 Offer 14- I. 剪绳子
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/07/19 16:10
 **/

public class Solution3 {
    // 经典 dp[] 配合 BigInteger
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = new BigInteger("1"); //内循环中会用到这个值
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("3");
        for (int i = 4; i <= n; i++) {
            //初始化dp[i]
            dp[i] = new BigInteger("0");
            //长度为i的绳子有i-1个剪切位置; 不论i是奇数还是偶数, 只考虑前 i/2 个剪切位置即可, 后面的剪切位置是重复的
            for (int j = 1; j <= i / 2; j++) {
                // 因为 j 和 i - j 都小于 i, 所以这是自底向上的计算方式
                dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
            }
        }

        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            System.out.println("n is : " + i + " , max is : " + new Solution3().cuttingRope(i));
        }
    }
}
