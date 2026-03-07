class Solution {
    public int singleNumber(int[] nums) {
        int num=0;
        Set<Integer> set = new HashSet<>(nums.length);
        for(int i: nums)
        {
            if(set.contains(i))
            {
                set.remove(i);
            }
            else
            {
                set.add(i);
            }
        }
        
        // set.stream().findFirst();
        for(Integer i : set)
        {
            num=i;
            break;
        }
        return num;
    }
}