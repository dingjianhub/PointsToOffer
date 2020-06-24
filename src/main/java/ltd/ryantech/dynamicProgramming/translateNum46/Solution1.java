package ltd.ryantech.dynamicProgramming.translateNum46;


/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.translateNum46
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/20 18:36
 **/

public class Solution1 {
    // 动态规划，空间未优化
    public int translateNum(int num) {
        String s = Integer.toString(num);
        int[] dp = new int[s.length() + 1]; // 以第 i 位置结尾的字符串的翻译方法，i 从 1 开始
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String window = s.substring(i - 2, i);
            if (window.compareTo("10") >= 0 && window.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(new Solution1().translateNum(num));
    }
}
