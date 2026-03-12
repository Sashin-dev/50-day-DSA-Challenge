/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int ans = 0;

        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            ans += (lMax < rMax) ? (lMax - height[left++]) : (rMax - height[right--]);

        }
        return ans;
    }
}
// @lc code=end
