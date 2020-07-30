package ltd.ryantech.twoPointers.lengthOfLongestSubstring48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.twoPointers.lengthOfLongestSubstring48
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @hard_level Easy
 * @tag Two Pointers // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/07/27 21:03
 **/

public class Solution2 {
    // 时间复杂度最优策略，仅遍历一遍 string 字符串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int length = s.length();
        int idx = -1; // 注意点:如果整个字符串中的字符不重复，那么 idx 可以设置为 0 或者 -1
        int windowSize = 1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                idx = Math.max(idx, map.get(s.charAt(i))); // 更新左指针 idx
            }
            map.put(s.charAt(i), i); // 哈希表记录
            windowSize = Math.max(windowSize, i - idx); // 更新结果
        }
        return windowSize;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
    }
}
