class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        for(int i=0; i <s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), null);
                // continue;
            }
            else
            {
                map.put(s.charAt(i), i);
            }

            // map.put(s.charAt(i), map.getOrDefault(s.charAt(i), null));
        }
        
        
       for (Map.Entry<Character,Integer> entry : map.entrySet()) 
       {      
           if(entry.getValue()!=null)
           {
               return entry.getValue();
           }
    }
        
        return -1;
    }
}