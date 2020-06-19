package ltd.ryantech.dynamicProgramming.maxSubArray42;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.maxSubArray42
 * @description
 * @create 2020/06/18 22:00
 **/

public class Solution2 {
    // 空间复杂度优化版
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int prev = nums[0]; // 保存当前的最优值，下轮循环变为上一个最优值，来判断是不是要加入 上轮的最优值
        int cur = nums[0]; // 当前可取的最优值
        int maxSum = nums[0]; // 最终要输出的最大值
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                cur = nums[i] + (Math.max(prev, 0));
                prev = cur;
                maxSum = Math.max(cur, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new Solution2().maxSubArray(nums);
        System.out.println(res);
    }
}
