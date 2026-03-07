class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        
        Map<Character, Integer>  map= new HashMap();
        for(Character c: word1.toCharArray() )
        {
            map.put(c, map.getOrDefault(c,0)+1);
        }

         
        for(Character c: word2.toCharArray() )
        {
            map.put(c, map.getOrDefault(c,0)-1);
        }

       for (Integer value : map.values()) {
            if(value>3 || value<-3)
            {
                return false;
            }
}

        return true;

        
    }
}