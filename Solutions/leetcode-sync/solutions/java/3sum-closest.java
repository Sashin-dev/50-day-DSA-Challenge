class Solution {
    public int threeSumClosest(int[] nums, int target) {
     int minSumJustGreater, maxSumJustLess;
        minSumJustGreater = Integer.MAX_VALUE;
        maxSumJustLess = Integer.MIN_VALUE;

        Arrays.sort(nums);
        int i, j, k;
        int newTarget;
        int sum = 0;
		
	// just like name suggests we keep maximum sum that is just less than target and minimum sum that is just greater than target so we can
//	achieve the closest possible value 
	
        for (i = 0; i < nums.length - 1; i++) {
            j = i + 1;
            k = nums.length - 1;
            newTarget = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == newTarget)
				// the closest sum to target is ... target 
                    return target;
                else if (nums[j] + nums[k] > newTarget) {
                    sum = nums[i] + nums[j] + nums[k];
                    minSumJustGreater = Math.min(sum, minSumJustGreater);
                    k--;
					
					//  reduce k as our sum is greater
                } else {
                    sum = nums[i] + nums[j] + nums[k];
                   maxSumJustLess = Math.max(sum, maxSumJustLess);
				   
				   // increase j  as our sum is less 
                    j++;
                }
            }
        }
		
		// in case the values remain unassigned 

        if (maxSumJustLess == Integer.MIN_VALUE)
            return minSumJustGreater;
        else if (minSumJustGreater == Integer.MAX_VALUE)
            return maxSumJustLess;

        int a = Math.abs(minSumJustGreater - target);
        int b = Math.abs(target - maxSumJustLess);
		
		// final step   chose between maxSumjust greater and min sum just less 
        return a < b ? minSumJustGreater : maxSumJustLess;
        
        
        
    }
}