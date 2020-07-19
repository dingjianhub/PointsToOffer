package ltd.ryantech.dynamicProgramming.cuttingRope14;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.dynamicProgramming.cuttingRope14
 * @description 剪绳子
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @hard_level Medium
 * @leetcdoe_Tag 动态规划 // https://leetcode-cn.com/tag/dynamic-programming/
 * @create 2020/05/09 15:33
 **/

public class Solution1 {
    // 自下而上 求解每个长度的最优解。存储在 dp[] 中
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0; // 题目中给定 n >= 2
        }
        if (n == 2) {
            return 1; // 给定最少剪成 2 段，那么只能剪成 1 * 1 的形式
        }
        if (n == 3) {
            return 2; // 可以剪成 1 * 1 * 1 和 1 * 2 的形式，最大值为 2
        }

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1; // 绳子长度为 1 时，不剪断，得到最大长度为 1
        products[2] = 2; // 绳子长度为 2 时，不剪断，得到最大长度为 2
        products[3] = 3; // 绳子长度为 3 时，不剪断，得到最大长度为 3

        int maxRes = 0;
        // 从绳子总长度大于 4 开始循环（动态规划）求解
        for (int i = 4; i <= n; i++) {
            maxRes = 0;
            // j <= i / 2;避免重复计算
            for (int j = 1; j <= i / 2; j++) {
                int tmp = products[j] * products[i - j]; // 例如 f(4) = f(1) * f(4 - 1); f(4) = f(3) * f(1) 重复计算
                maxRes = Math.max(maxRes, tmp);
                products[i] = maxRes;
            }
        }
        maxRes = products[n];
        return maxRes;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().cuttingRope(2));
        System.out.println(new Solution1().cuttingRope(10));
    }
}
