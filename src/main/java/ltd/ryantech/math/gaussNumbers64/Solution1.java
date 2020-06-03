package ltd.ryantech.math.gaussNumbers64;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.math.gaussNumbers64
 * @description 面试题64. 求1+2+…+n
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @hard_level Medium
 * @tag Math // https://leetcode-cn.com/tag/math/
 * @create 2020/06/03 20:16
 **/

public class Solution1 {
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution1().sumNums(n));
    }
}
