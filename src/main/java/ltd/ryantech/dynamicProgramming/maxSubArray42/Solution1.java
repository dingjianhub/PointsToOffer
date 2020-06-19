package ltd.ryantech.dynamicProgramming.maxSubArray42;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxSubArray42
 * @description 面试题42. 连续子数组的最大和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @hard_level Easy
 * @tag Dynamic Programming // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/06/18 21:56
 **/

public class Solution1 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0]; // dp[i] 表示以 i 结尾的子数组的最大和
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution1().maxSubArray(nums));
    }
}
