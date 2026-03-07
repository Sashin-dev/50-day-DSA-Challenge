class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n  = nums.length;
        int[] resultNum = new int[n];

        int leftProduct=1, rightProduct = 1;
        for(int i=0; i<nums.length; i++){
            resultNum[i] =  leftProduct;
            leftProduct*=nums[i];
        }

        for(int j=nums.length-1; j>=0; j--){
            resultNum[j] = rightProduct * resultNum[j];
            rightProduct = rightProduct * nums[j];
        }
        return resultNum;
    }
}