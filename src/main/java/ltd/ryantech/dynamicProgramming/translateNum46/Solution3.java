package ltd.ryantech.dynamicProgramming.translateNum46;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.translateNum46
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/20 18:53
 **/

public class Solution3 {
    // 求余法
    // 从右向左 遍历
    public int translateNum(int num) {
        int dp_2 = 1;
        int dp_1 = 1;
        int dpRes = dp_1; // 如果只有 1 位数字，那么值为 dp_1
        int x = 0;
        int y = num % 10;
        while (num != 0) {
            num = num / 10;
            x = num % 10;
            int tmp = 10 * x + y;
            dpRes = (tmp >= 10 && tmp <= 25) ? dp_1 + dp_2 : dp_1;
            // 动态规划最优解的 滚动更新
            dp_2 = dp_1;
            dp_1 = dpRes;
            // 更新 y 的值
            y = x;
        }
        return dpRes;
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(new Solution3().translateNum(num));
    }
}
