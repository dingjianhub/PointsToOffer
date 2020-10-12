package ltd.ryantech.array.findDuplicateNumber3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findDuplicateNumber3
 * @description 剑指 Offer 03. 数组中重复的数字
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @hard_level Easy
 * @create 2020/08/25 10:27
 **/

public class Solution3 {
    // 哈希表法
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 特判，如果存在有数字范围超过了给定的范围，那么直接返回 -1
        for (int i : nums) {
            if (i < 0 || i > nums.length - 1) {
                return -1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11};
        System.out.println(new Solution3().findRepeatNumber(nums));
    }
}
