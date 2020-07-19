package ltd.ryantech.dynamicProgramming.maxProfit63;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxProfit63
 * @description 剑指 Offer 63. 股票的最大利润
 * @leetcode_CN_url // https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @hard_level Medium
 * @tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/07/13 08:22
 **/

public class Solution2 {
    // 动态规划优化版
    // 最大利润来自于 price[i] - minPrice , 即找到前面最小的价格即可
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = prices[1] - minPrice;

        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < minPrice) {
                minPrice = prices[i - 1];
            }
            int curProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, curProfit);
        }
        // 如果无法完成交易，即左侧下跌趋势，那么求出的是最小的亏损。需要输出 0 。
        return Math.max(maxProfit, 0);
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution2().maxProfit(prices1));
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(new Solution2().maxProfit(prices2));
    }

}
