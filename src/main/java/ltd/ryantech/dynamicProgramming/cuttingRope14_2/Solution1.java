package ltd.ryantech.dynamicProgramming.cuttingRope14_2;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.cuttingRope14_2
 * @description 剑指 Offer 14- I. 剪绳子
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/07/18 16:06
 **/

public class Solution1 {
    // 循环取余法
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;

        long maxRes = 1L;
        int p = (int) 1e9 + 7;
        // 贪心算法，优先切三，其次切二
        while (n > 4) {
            maxRes = maxRes * 3 % p;
            n -= 3;
        }
        // 结束循环只有三种情况，分别是 n = 2 , 3 , 4
        // 当结果为 n = 4 时，切分为 2 + 2，其乘积结果依旧为 4
        return (int) (maxRes * n % p);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("n is : " + i + " , max is : " + new Solution1().cuttingRope(i));
        }
    }
}
