package ltd.ryantech.string.printNumbers17;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.string.printNumbers17
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/07/23 14:54
 **/

public class Solution3 {
    public void printNumbers(int n) {
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        while (!increment(str)) {
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            System.out.println(str.substring(index));
        }
    }

    public boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char) (str.charAt(i) + 1);
            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
            }
            // 没发生进位则跳出for循环
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

    public static void main(String[] args) {
        new Solution3().printNumbers(18392432);
    }
}
