package ltd.ryantech.deepFirstSearch.permutation38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.deepFirstSearch.permutation38
 * @description
 * @create 2020/07/30 15:00
 **/

public class Solution1 {
    List<String> res = new ArrayList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);  // 从第一层开始递归
        return res.toArray(new String[res.size()]); //将字符串数组ArrayList转化为String类型数组
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        String[] res = new Solution1().permutation("abc");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
