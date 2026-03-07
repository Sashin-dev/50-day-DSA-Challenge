class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] outputArr = new int[nums.length];
        int highestSquareIdx =right;
        while(left<=right)
        {
            if(nums[left]*nums[left] > nums[right]* nums[right])
            {
                outputArr[highestSquareIdx--] = nums[left]*nums[left];
                left++;
            }
            else
            {
                outputArr[highestSquareIdx--] = nums[right]*nums[right];
                right--;
            }
        }
        return outputArr;
    }
}