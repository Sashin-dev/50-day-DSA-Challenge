class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, 0, nums.length-1, true, -1);
        if(ans[0]!=-1){
            ans[1] = search(nums, target, 0, nums.length-1, false, -1);
        }
        return ans;
    }

    private int search(int[] nums, int target, int sI, int eI, boolean searchStart, int ans){
        if(sI>eI)
         return ans;

         int mid = sI + (eI-sI)/2;

         if(nums[mid]==target){
            ans = mid;
            if(searchStart){
                return search(nums, target, sI, mid-1, searchStart, ans);
            }
            else{
                return search(nums, target, mid+1, eI, searchStart, ans);
            }
         }
         if(nums[mid]>target){
            return search(nums, target, sI, mid-1, searchStart, ans);
         }
         else{
            return search(nums, target, mid+1, eI, searchStart, ans);
         }
    }
}