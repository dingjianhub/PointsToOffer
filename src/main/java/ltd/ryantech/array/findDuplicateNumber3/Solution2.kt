package ltd.ryantech.array.findDuplicateNumber3

import java.util.*

/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findDuplicateNumber
 * @description 数组中重复的数字
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @hard_level Easy
 * @create 2020/05/21 13:53
 **/

class SolutionKT2 {
    fun findRepeatNumber(nums: IntArray): Int {
        if (nums.isEmpty())
            return -1

        for (num in nums.iterator()) {
            if (num < 0 || num > nums.size - 1)
                return -1
        }

        Arrays.sort(nums)
        for (i in nums.indices) {
            if (nums[i] == nums[nums[i + 1]]) {
                return nums[i]
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    var nums: IntArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11);
    println(SolutionKT2().findRepeatNumber(nums))
}
