/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> finalResult = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int currSum = -nums[i];

            while (left < right) {
                if (nums[left] + nums[right] == currSum) {
                    finalResult.add(List.of(nums[i], nums[left], nums[right]));

                    int leftVal = nums[left++];
                    int rightVal = nums[right--];

                    while (left < right && leftVal == nums[left]) {
                        left++;
                    }
                    while (left < right && rightVal == nums[right]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > currSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return finalResult;

    }
}
// @lc code=end
