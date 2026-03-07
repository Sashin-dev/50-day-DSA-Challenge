class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet(nums1.length);
        Set<Integer> set2 = new HashSet(nums2.length);

        Set<Integer> list1 = new HashSet(nums1.length);
        Set<Integer> list2 = new HashSet(nums2.length);

        for(int i : nums1)
            set1.add(i);
        for(int i : nums2)
            set2.add(i);

        for(int i: nums2)
        {
            if(!set1.contains(i))
            {
                list1.add(i);
            }
            // if(list1.size()==2)
            //     break;
        }
        for(int i: nums1)
        {
            if(!set2.contains(i))
            {
                list2.add(i);
            }
            // if(list2.size()==2)
            //     break;
        }

        List<List<Integer>> listF = new ArrayList(2);
        List<Integer> listA = new ArrayList<>(list2);
        List<Integer> listB = new ArrayList<>(list1);
        listF.add(listA);
        listF.add(listB);

        return listF;
    }
}