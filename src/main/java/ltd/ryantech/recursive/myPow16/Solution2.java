package ltd.ryantech.recursive.myPow16;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.recursive.myPow16
 * @description 剑指 Offer 16. 数值的整数次方
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 递归 // https://leetcode-cn.com/tag/recursion/
 * @create 2020/07/21 15:09
 **/

public class Solution2 {
    public double myPow(double x, int n) {
        // 当底数为 0 且 幂次为 0 时，输出 0
        if (Math.abs(x - 0) < 1e-7 && n == 0) {
            return 0;
        }

        long t;
        if (n < 0) {
            t = -(long) n;
            return 1 / pow(x, t);
        }

        return pow(x, n);
    }

    private double pow(double x, long n) {
        // 递归停止的条件
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }

        double res = pow(x, n / 2);
        res *= res;
        if (n % 2 == 1) {
            res *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().myPow(2.000, 10));
        System.out.println(new Solution2().myPow(2.10000, 3));
        System.out.println(new Solution2().myPow(2.0000, -2));
        System.out.println(new Solution2().myPow(0.44528, 0));
        System.out.println(new Solution2().myPow(1.0000, 2147483647));
        System.out.println(new Solution2().myPow(2.0000, -2147483648));
    }
}
