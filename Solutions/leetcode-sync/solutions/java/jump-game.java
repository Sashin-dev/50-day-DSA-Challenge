class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int left = 0;
        int maxReachable = 0;
        while(left <= maxReachable && maxReachable < len-1)
         {
             maxReachable = Math.max(maxReachable, left+nums[left]);
             left++;
        }
        return maxReachable >= len-1;

    }
}