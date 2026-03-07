class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int sum=0;
        int lsum=0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==1)
            {
                lsum++;
            }
            else
            {
                lsum=0;
            }
            
            if(lsum>sum)
            {
                sum=lsum;
            }
            
            
        }
        return sum;
    }
}