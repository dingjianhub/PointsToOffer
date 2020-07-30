package ltd.ryantech.twoPointers.lengthOfLongestSubstring48;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.twoPointers.lengthOfLongestSubstring48
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @hard_level Easy
 * @tag Two Pointers // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/07/27 20:15
 **/

public class Solution1 {
    // HashSet + 双指针，滑动窗口的思想
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int length = s.length();
        int front = 0;
        int back = 0;
        int windowSize = 1;
        Set<Character> set = new HashSet<>();

        for (front = 0; front < length; front++) {
            set.clear();
            for (back = front; back < length; back++) {
                if (set.contains(s.charAt(back))) {
                    break;
                } else {
                    set.add(s.charAt(back));
                }
            }
            windowSize = Math.max(back - front, windowSize);
        }
        return windowSize;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution1().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution1().lengthOfLongestSubstring("pwwkew"));
    }
}
