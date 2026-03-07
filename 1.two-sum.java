/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.getOrDefault(nums[i], -1) >= 0) {
                return new int[] { i, numMap.get(nums[i]) };
            } else {
                numMap.put(target - nums[i], i);
            }
        }
        return null;
    }
}
// @lc code=end
