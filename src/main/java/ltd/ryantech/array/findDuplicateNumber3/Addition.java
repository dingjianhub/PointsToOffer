package ltd.ryantech.array.findDuplicateNumber3;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findDuplicateNumber3
 * @description 不修改数组找出重复的数字
 * @create 2020/08/25 11:11
 **/

/**
 * 《剑指 Offer》 中给出的拓展
 * 不修改数组找出重复的数字。
 * 在一个长度 n + 1 的数组里的所有都在 1 ~ n 的范围内
 * 所以数组中至少有一个数字是重复的
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如：如果输入的长度为 8 的数组 {2,3,5,4,3,2,6,7}，那么输出的重复数字应该是 2 或者 3
 */
public class Addition {

    public int getDuplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            int count = countRange(nums, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(new Addition().getDuplication(nums));
    }
}
