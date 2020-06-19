package ltd.ryantech.hashmap.firstUniqChar50;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.hashmap.firstUniqChar50
 * @description 面试题50. 第一个只出现一次的字符
 * @leetcode_CN_url // https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @hard_level Easy
 * @tag HashTable // https://leetcode-cn.com/tag/hash-table/
 * @create 2020/06/19 13:47
 **/

public class Solution1 {
    public char firstUniqChar(String s) {
        int[] counter = new int[26];
        for (Character c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (Character c : s.toCharArray()) {
            if (counter[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqCharPlus(String s) {
        int[] counter = new int[128];
        for (Character c : s.toCharArray()) {
            counter[(int) c]++;
        }
        for (Character c : s.toCharArray()) {
            if (counter[(int) c] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(new Solution1().firstUniqCharPlus(s1));
        String s2 = "";
        System.out.println(new Solution1().firstUniqCharPlus(s2) == ' ');
    }
}
