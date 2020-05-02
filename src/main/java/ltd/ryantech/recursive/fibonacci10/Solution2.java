package ltd.ryantech.recursive.fibonacci10;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.recursive.fibonacci10
 * @description 斐波那契数列
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @hard_level Easy
 * @create 2020/05/02 19:27
 **/

public class Solution2 {
    public int fib(int n) {
        if (n < 0) {
            return -1;
        }

        int[] res = {0, 1};
        if (n < 2) {
            return res[n];
        }

        int fibOne = 1; // fib(n - 1)
        int fibTwo = 0; // fib(n - 2)
        int fibSum = 0; // fib(n) = fib(n - 1) + fib(n - 2);
        for (int i = 2; i <= n; i++) {
            fibSum = (fibOne + fibTwo) % 1000000007;
            fibTwo = fibOne;
            fibOne = fibSum;
        }
        return fibSum;
    }

    public static void main(String[] args) {
        int n = 869709;
        int sum = new Solution2().fib(n);
        System.out.println(sum);
    }
}
