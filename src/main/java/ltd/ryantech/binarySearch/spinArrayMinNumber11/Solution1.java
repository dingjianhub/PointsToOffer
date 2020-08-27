package ltd.ryantech.binarySearch.spinArrayMinNumber11;

import java.util.jar.JarEntry;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.binarySearch.spinArrayMinNumber11
 * @description 旋转数组的最小数字
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @hard_level Easy
 * @create 2020/05/03 10:19
 **/

public class Solution1 {
    // 代码虽然简洁，但是本题需要分情况讨论，比较难以考虑
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--; // 简约而不简单
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(new Solution1().minArray(numbers));
        int[] numbers1 = {1, 0, 1, 1, 1};
        System.out.println(new Solution1().minArray(numbers1));
    }
}
