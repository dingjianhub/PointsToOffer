package ltd.ryantech.twoPointers.recorderOddEven21;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.twoPointers
 * @description 面试题21. 调整数组顺序使奇数位于偶数前面
 * @leetcode_CN_url // https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @hard_level Easy
 * @tag Two Pointers // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/06/14 14:35
 **/

public class Solution1 {
    /**
     * 《剑指 Offer》 面试题21. 调整数组顺序使奇数位于偶数前面
     * 初级解法 即 不可重用的 方法
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int front = 0;
        int back = nums.length - 1;
        int tmp = 0;
        while (front < back) {
            while (front < back && nums[front] % 2 != 0) {
                front++;
            }
            while (front < back && nums[back] % 2 == 0) {
                back--;
            }
            tmp = nums[front];
            nums[front] = nums[back];
            nums[back] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] ans = new Solution1().exchange(nums);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
