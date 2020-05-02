package ltd.ryantech.recursive.fibonacci10;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.recursive.fibonacci10
 * @description 斐波那契数列
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @hard_level Easy
 * @create 2020/05/02 16:07
 **/

public class Solution1 {
    // 经典递归算法
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 30;
        int sum = new Solution1().fib(n);
        System.out.println(sum);
    }
}
