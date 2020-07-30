package ltd.ryantech.twoPointers.recorderOddEven21;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.twoPointers
 * @description 面试题21. 调整数组顺序使奇数位于偶数前面
 * @leetcode_CN_url // https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @hard_level Easy
 * @tag Two Pointers // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/06/14 14:47
 **/

@FunctionalInterface
interface IsEven {
    boolean isEven(int number);
}

public class Solution2 {
    public int[] exchange(int[] nums, IsEven isEven) {
        int front = 0;
        int back = nums.length - 1;
        int tmp = 0;
        while (front < back) {
            while (front < back && isEven(nums[front])) {
                front++;
            }
            while (front < back && isEven(nums[back])) {
                back--;
            }
            tmp = nums[front];
            nums[front] = nums[back];
            nums[back] = tmp;
        }
        return nums;
    }


    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {

    }
}
