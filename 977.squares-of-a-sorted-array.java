/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int currIndex = right;
        int[] outputArr = new int[nums.length];

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                outputArr[currIndex--] = nums[left] * nums[left];
                left++;
            } else {
                outputArr[currIndex--] = nums[right] * nums[right];
                right--;
            }
        }
        return outputArr;
    }
}
// @lc code=end
