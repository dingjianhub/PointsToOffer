package ltd.ryantech.hashmap.firstUniqChar50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.hashmap.firstUniqChar50
 * @description 面试题50. 第一个只出现一次的字符
 * @leetcode_CN_url // https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @hard_level Easy
 * @tag HashTable // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/06/19 13:52
 **/

public class Solution2 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(new Solution2().firstUniqChar(s1));
        String s2 = "";
        System.out.println(new Solution2().firstUniqChar(s2) == ' ');
    }
}
