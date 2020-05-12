package ltd.ryantech.bitManipulation.hammingWeight15;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.bitManipulation.hammingWeight15
 * @description 汉明重量 二进制中 1 的个数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @hard_level Easy
 * @tag // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/05/12 11:07
 **/

public class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >>> 1; // 无符号右移
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Solution1().hammingWeight(n));
    }
}
