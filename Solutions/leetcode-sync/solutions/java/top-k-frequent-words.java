class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> wordsList = new ArrayList(k);
        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        
        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>
            ((i1, i2)-> {
                return i2-i1;
                }
            );
        
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            List<String> list = sortedMap.getOrDefault(entry.getValue(), new ArrayList());
            list.add(entry.getKey());
            sortedMap.put(entry.getValue(), list);
        }
        
        int i=0;
        
        for(List<String> strs:sortedMap.values()){
            Collections.sort(strs);
            for(String str:strs){
                wordsList.add(str);
                i++;
                if(i==k)break;
            }
            if(i==k)break;
        }
        return wordsList;
    }
}