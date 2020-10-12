package ltd.ryantech.array.findDuplicateNumber3;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findDuplicateNumber
 * @description 剑指 Offer 03. 数组中重复的数字
 * @Leetcode_CN_url //https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @hard_level Easy
 * @create 2020/04/26 11:38
 **/

public class Solution1 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 特判，如果存在有数字范围超过了给定的范围，那么直接返回 -1
        for (int num : nums) {
            if (num < 0 || num > nums.length - 1) {
                return -1;
            }
        }

        int t;
        // 交换法，期望使得每一个元素落在其 index 的位置上
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11};
        System.out.println(new Solution1().findRepeatNumber(nums));
    }
}
