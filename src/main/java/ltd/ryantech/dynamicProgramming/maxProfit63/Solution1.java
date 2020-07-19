package ltd.ryantech.dynamicProgramming.maxProfit63;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxProfit63
 * @description 剑指 Offer 63. 股票的最大利润
 * @leetcode_CN_url // https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @hard_level Medium
 * @tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/07/10 10:48
 **/

public class Solution1 {
    // 暴力枚举全部数对的方法
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxPrice = Math.max(prices[j] - prices[i], maxPrice);
            }
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution1().maxProfit(prices1));
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(new Solution1().maxProfit(prices2));
    }
}
