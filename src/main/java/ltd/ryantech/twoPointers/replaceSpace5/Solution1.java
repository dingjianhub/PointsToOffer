package ltd.ryantech.twoPointers.replaceSpace5;

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.twoPointers.replaceSpace
 * @description 面试题05. 替换空格
 * @leetcode_CN_url // https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @hard_level Easy
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/04/26 15:07
 **/

public class Solution1 {
    public String replaceSpace(String s) {
        // 按照书本的思路指示，处理 s 按照 array 的方式来处理
        // 使用 2 个指针，从 s 的尾部向前处理
        if (s == null || s.length() == 0) {
            return "";
        }

        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\u0020') { // 空格的 Unicode 编码
                spaceCount++;
            }
        }

        char[] chars = new char[s.length() + 2 * spaceCount];
        int p = s.length() - 1;
        int q = chars.length - 1;
        while (p >= 0) {
            if (s.charAt(p) != '\u0020') {
                chars[q] = s.charAt(p);
                q--;
            } else {
                chars[q] = '0';
                chars[q - 1] = '2';
                chars[q - 2] = '%';
                q = q - 3;
            }
            p--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(new Solution1().replaceSpace(str));
    }
}
