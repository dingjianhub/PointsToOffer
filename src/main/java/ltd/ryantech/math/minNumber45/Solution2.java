package ltd.ryantech.math.minNumber45;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.minNumber45
 * @description 剑指 Offer 45. 把数组排成最小的数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/08/21 10:58
 **/

public class Solution2 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    // 快速排序
    public void fastSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }


    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution2().minNumber(nums));
    }
}
