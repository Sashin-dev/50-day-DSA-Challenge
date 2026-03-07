class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] response = new int[2]; 
        for(int i=0; i<nums.length; i++){
            if(sumMap.containsKey(nums[i])){
                response = new int[]{i, sumMap.get(nums[i])};
                break;
            }
            else{
                sumMap.put(target-nums[i], i);
            }
        }
        return response;
    }
}