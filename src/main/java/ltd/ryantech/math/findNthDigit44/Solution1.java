package ltd.ryantech.math.findNthDigit44;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.findNthDigit44
 * @description 剑指 Offer 44. 数字序列中某一位的数字
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/08/19 16:39
 **/

public class Solution1 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.确定 n 所在 数字 的 位数 ，记为 digit
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.确定 n 所在的 数字 ，记为 num
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.确定 n 是 num 中的哪一数位，并返回结果
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findNthDigit(5));
        System.out.println(new Solution1().findNthDigit(13));
        System.out.println(new Solution1().findNthDigit(19));
    }
}
