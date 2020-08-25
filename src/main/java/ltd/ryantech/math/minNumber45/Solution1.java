package ltd.ryantech.math.minNumber45;

import java.util.Arrays;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.minNumber45
 * @description 剑指 Offer 45. 把数组排成最小的数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/08/20 14:52
 **/

public class Solution1 {
    // 调用类库的快排
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution1().minNumber(nums));
    }
}
