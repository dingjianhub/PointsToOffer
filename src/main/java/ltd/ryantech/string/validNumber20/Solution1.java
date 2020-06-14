package ltd.ryantech.string.validNumber20;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.string.validNumber20
 * @description 面试题20. 表示数值的字符串
 * @leetcode_CN_url // https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @hard_level Medium
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/06/14 14:45
 **/

public class Solution1 {
    public boolean isNumber(String s) {
        // 正负号 ，小数点，e 都只能出现一次
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean numSeen = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                if (dotSeen || eSeen) {
                    // 94e2.5 非法 87e89 合法
                    // 78.83.47 非法
                    return false;
                }
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                // 出现 e 必须要求 e 是第一次出现，且出现了数字
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false; // 重置。应对 123e 的情况
            } else if (str[i] == '+' || str[i] == '-') {
                // 只允许出现 2 次，一次在 e 之后，一次在 开头
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }

    public static void main(String[] args) {
        String s1 = "e";
        System.out.println(new Solution1().isNumber(s1));
    }
}
