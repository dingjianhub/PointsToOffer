package ltd.ryantech.dynamicProgramming.translateNum46;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.translateNum46
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/20 18:44
 **/

public class Solution2 {
    // 动态规划优化版算法
    public int translateNum(int num) {
        String s = Integer.toString(num);
        int dp_2 = 1;
        int dp_1 = 1;
        int dpRes = dp_1; // 如果只有 1 位数字，那么值为 dp_1
        for (int i = 2; i <= s.length(); i++) {
            String window = s.substring(i - 2, i);
            if (window.compareTo("10") >= 0 && window.compareTo("25") <= 0) {
                dpRes = dp_1 + dp_2;
            } else {
                dpRes = dp_1;
            }
            // 滚动更新最新值
            dp_2 = dp_1;
            dp_1 = dpRes;
        }
        return dpRes;
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(new Solution2().translateNum(num));
    }
}
