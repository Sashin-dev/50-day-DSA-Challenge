class Solution {
   public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(correct < nums.length && correct >= 0 && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else
                i++;
        }

        for (int n = 0; n < nums.length; n++){
            if(n != nums[n]-1)
                return n+1;
        }
        return i+1;
    }
}