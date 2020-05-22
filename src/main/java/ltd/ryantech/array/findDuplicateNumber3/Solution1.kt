package ltd.ryantech.array.findDuplicateNumber3


/**
 * @author ryan
 * @program PointsToOffer
 * @package_name ltd.ryantech.array.findDuplicateNumber
 * @description 数组中重复的数字
 * @Leetcode_CN_url // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @hard_level Easy
 * @create 2020/05/21 13:34
 **/

class SolutionKT1 {
    fun findRepeatNumber(nums: IntArray): Int {
        if (nums.isEmpty())
            return -1

        for (i in nums.indices) {
            if (nums[i] < 0 || nums[i] > nums.size - 1)
                return -1
        }

        var tmp: Int
        for (i in nums.indices) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]])
                    return nums[i]
                tmp = nums[i]
                nums[i] = nums[tmp]
                nums[tmp] = tmp
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    var nums: IntArray = intArrayOf(2, 3, 1, 0, 2, 5, 3)
    println(SolutionKT1().findRepeatNumber(nums))
}