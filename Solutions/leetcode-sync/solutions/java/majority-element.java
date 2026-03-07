class Solution {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        // Arrays.stream(nums).boxed()
            
        Map<Integer, Integer> map = new HashMap();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

         
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size/2) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
}