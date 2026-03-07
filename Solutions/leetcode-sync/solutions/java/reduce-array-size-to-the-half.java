class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Integer> freqs = new ArrayList<>(map.values());
        Collections.sort(freqs, Collections.reverseOrder());
        
        int n=arr.length;
        int totalElement = n;
        int i=0;
        while(totalElement>n/2)
        {
            totalElement-=freqs.get(i);
            i++;
        }
        return i;
    }
}