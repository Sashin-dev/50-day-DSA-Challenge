class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        return binarySearch(nums, start, end, target);
        
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        int mid = start + (end-start)/2;
        if(start>end)
        {
            return -1;
        }
        
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            return binarySearch(nums, start, mid-1, target);
        }
            return binarySearch(nums, mid+1, end, target);
    }

}