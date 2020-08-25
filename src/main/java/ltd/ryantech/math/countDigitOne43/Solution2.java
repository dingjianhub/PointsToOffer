package ltd.ryantech.math.countDigitOne43;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.countDigitOne43
 * @description 剑指 Offer 43. 1～n整数中1出现的次数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/08/19 11:04
 **/

public class Solution2 {
    public int countDigitOne(int n) {
        if (n <= 0) { // 增加程序的健壮性
            return 0;
        }

        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0; // 条件初始化
        while (high != 0 || cur != 0) { // cur != 0 处理最高位的情况
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit; // 扩大低位
            cur = high % 10;
            high /= 10; // 缩小高位
            digit *= 10; // 因子增长
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().countDigitOne(824883294));
    }
}
