package ltd.ryantech.bitManipulation.hammingWeight15;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.bitManipulation.hammingWeight15
 * @description 汉明重量 二进制中 1 的个数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @hard_level Easy
 * @tag // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/05/12 11:14
 **/

public class Solution2 {
    // you need to treat n as an unsigned value
    // 掩码做法
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask = mask << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Solution2().hammingWeight(n));
    }
}
