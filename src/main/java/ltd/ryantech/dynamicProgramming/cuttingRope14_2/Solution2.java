package ltd.ryantech.dynamicProgramming.cuttingRope14_2;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.cuttingRope14_2
 * @description 剑指 Offer 14- I. 剪绳子
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/07/19 14:57
 **/

public class Solution2 {
    // 快速幂求余法
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;

        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }

        if (b == 0) return (int) (rem * 3 % p); // 全部切分为 3 长度的情况下
        if (b == 1) return (int) (rem * 2 * 2 % p); // 剩余长度为 1,拿出一个 3 ，补为 2 + 2
        return (int) (rem * 2 * 3 % p); // 剩余长度为 2，例如绳子长度为 8，最后的结果为 2 * 3 * rem
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            System.out.println("n is : " + i + " , max is : " + new Solution2().cuttingRope(i));
        }
    }
}
