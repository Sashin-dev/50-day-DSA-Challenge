class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int[] res = new int[k];
        HashMap<Integer, Integer> frequencyMap = new HashMap();
        for(int i=0; i<nums.length; i++)
        {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2)
        );

        for(int n : frequencyMap.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }

        for(int i=k-1; i>=0; --i){
            res[i] = heap.poll();
        }
        return res;
    }
}