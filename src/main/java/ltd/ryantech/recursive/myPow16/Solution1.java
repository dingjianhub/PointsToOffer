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


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().myPow(2.000, 10));
    }
}
