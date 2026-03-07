class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int maxSumSoFar=0;
        int res = Integer.MAX_VALUE;

        for(; right<nums.length;right++ ){
            maxSumSoFar+=nums[right];
            while(maxSumSoFar>=target){
                res = Math.min(res, (right-left)+1);
                maxSumSoFar-=nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res; 
    }
}