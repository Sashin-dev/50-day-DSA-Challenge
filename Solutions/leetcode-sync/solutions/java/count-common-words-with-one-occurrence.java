class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> word1Map = new HashMap<String, Integer>(words1.length);
        Map<String, Integer> word2Map = new HashMap<String, Integer>(words2.length);
        int count=0;
        for(String word : words1)
        {
            word1Map.put(word, word1Map.getOrDefault(word, 0)+1);
        }
        
        for(String word : words2)
        {
            word2Map.put(word, word2Map.getOrDefault(word, 0)+1);
        }
        
        for (Map.Entry<String,Integer> entry : word1Map.entrySet()) 
        {
            if(entry.getValue()==1 && word2Map.getOrDefault(entry.getKey(), 0)==1)
            {
                ++count;
            }
        }
        return count;
    }
}