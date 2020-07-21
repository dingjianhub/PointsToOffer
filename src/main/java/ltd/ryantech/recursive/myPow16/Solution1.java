package ltd.ryantech.recursive.myPow16;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.recursive.myPow16
 * @description 剑指 Offer 16. 数值的整数次方
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 递归 // https://leetcode-cn.com/tag/recursion/
 * @create 2020/07/19 16:45
 **/

public class Solution1 {
    public double myPow(double x, int n) {
        // 当底数为 0 且 幂次为 0 时，输出 0
        if (Math.abs(x - 0) < 1e-7 && n == 0) {
            return 0;
        }

        double res = 1.0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
            return res;
        } else if (n < 0) {
            int t = Math.abs(n);
            for (int i = 0; i < t; i++) {
                res = res * x;
            }
            return 1 / res;
        } else {
            return 1.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().myPow(2.000, 10));
        System.out.println(new Solution1().myPow(2.10000, 3));
        System.out.println(new Solution1().myPow(2.0000, -2));
        System.out.println(new Solution1().myPow(0.44528, 0));
        System.out.println(new Solution1().myPow(1.0000, 2147483647));
    }
}
