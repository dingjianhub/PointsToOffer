package ltd.ryantech.array.findDuplicateNumber3;

import java.util.Arrays;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findDuplicateNumber
 * @description 数组中重复的数字
 * @Leetcode_CN_url //https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @hard_level Easy
 * @create 2020/04/26 13:24
 **/

public class Solution2 {
    // 排序法，简单明了
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int num : nums) {
            if (num < 0 || num > nums.length - 1) {
                return -1;
            }
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11};
        System.out.println(new Solution2().findRepeatNumber(nums));
    }
}
