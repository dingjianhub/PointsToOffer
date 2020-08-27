package ltd.ryantech.string.printNumbers17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.string.printNumbers17
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/07/21 21:14
 **/


public class Solution2 {
    private List<Integer> list;

    public int[] printNumbers(int n) {
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int n, int i, StringBuilder sb) {
        if (i == n) {
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() != 0) {
                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            sb.append(j);
            dfs(n, i + 1, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] res = new Solution2().printNumbers(8);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
