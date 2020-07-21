package ltd.ryantech.string.printNumbers17;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.string.printNumbers17
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/07/21 21:04
 **/

public class Solution1 {
    // leetcode-cn AC 代码
    // 不考虑大数的情况，没有太大的意义
    public int[] printNumbers(int n) {
        int length = 1;
        for (int i = 0; i < n; i++) {
            length *= 10;
        }
        int[] res = new int[length - 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution1().printNumbers(1);
        for (int i = 0;i < res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
