package ltd.ryantech.math.nthUglyNumber49;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.nthUglyNumber49
 * @description 剑指 Offer 49. 丑数
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/chou-shu-lcof/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/08/21 14:20
 **/

public class Solution2 {
    public boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int res = 0;
        int idx = 0;
        while (idx < n) {
            res++;
            if (isUgly(res)) {
                idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().nthUglyNumber(1370));
    }
}
