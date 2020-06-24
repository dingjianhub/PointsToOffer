package ltd.ryantech.binarySearch.searchTargetInSortedArray53;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name ltd.ryantech.binarySearch.searchTargetInSortedArray53
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @leetcode_CN_url // https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @hard_level Easy
 * @tag Binary Search // https://leetcode-cn.com/tag/binary-search/
 * @create 2020/06/21 13:38
 **/

public class Solution1 {
    // 《剑指 Offer》中提到的最朴素解法，最坏复杂度为 O(n)
    //  找到一个 target 所在下标，然后前后扫描
    //  这里找到的 target 所在的下标，具体是第几个，是不能确定的
    public int search(int[] nums, int target) {
        int cnt = 0;
        int pivot = 0;
        // 经典 “三分式” 两分查找
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                pivot = mid;
                cnt++;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = pivot;
        right = pivot;
        while (left > 0 && nums[left - 1] == target) {
            cnt++;
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            cnt++;
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        System.out.println(new Solution1().search(nums1, 8));

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        System.out.println(new Solution1().search(nums2, 6));

        int[] nums3 = {1, 1, 2};
        System.out.println(new Solution1().search(nums3, 1));
    }
}
