package ltd.ryantech.bitManipulation.hammingWeight15;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.bitManipulation.hammingWeight15
 * @description 汉明重量 二进制中 1 的个数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @hard_level Easy
 * @tag // https://leetcode-cn.com/tag/bit-manipulation/
 * @create 2020/05/12 14:08
 **/

public class Solution3 {
    // you need to treat n as an unsigned value
    // 每次消去 n 最右边的 1，消除几次就有几个 1
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Solution3().hammingWeight(n));
    }
}
