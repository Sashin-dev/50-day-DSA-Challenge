class Solution {
    public void nextPermutation(int[] nums) {
        int k = nums.length-2;
        
        while(k>=0 && nums[k]>=nums[k+1])
        {
            k--;
        }
        if(k==-1)
        {
            Arrays.sort(nums);
            return;
        }
        
        for(int i=nums.length-1; i>k; --i)
        {
            if(nums[k] < nums[i])
            {
                //swap
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                break;
            }
        }
        reverse(nums, k+1, nums.length);
        // Collections.reverse(intList.subList(k+1, nums.length));
        
    }
    
    private void reverse(int a[], int startIndex, int endIndex)
    {
        for (int i = 0; i < (endIndex-startIndex) / 2; i++) {
            int temp = a[startIndex + i];
            a[startIndex + i] = a[endIndex - i-1];
            a[endIndex- i-1] = temp;
        }
    }
}