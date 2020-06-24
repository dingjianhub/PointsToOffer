package ltd.ryantech.dynamicProgramming.translateNum46;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.translateNum46
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/20 19:02
 **/

public class Solution4 {
    // 递归思路
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        // 12258
        int window = num % 100;
        if (window <= 9 || window >= 26) {
            return translateNum(num / 10);
        } else {
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(new Solution4().translateNum(num));
    }
}
