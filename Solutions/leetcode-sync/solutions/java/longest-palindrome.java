class Solution {
    public int longestPalindrome(String s) {
        
        int l =0;
        int isHavingOneMoreChar=0;
        if(s==null || s.length()==0)
        {
            return l;
        }
        
        Map<Character, Integer> map = new HashMap();
        for(Character c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        
        for(Map.Entry<Character,Integer>  entry: map.entrySet())
        {
            if(entry.getValue()/2 >0)
            {
                l+=(entry.getValue()/2)*2;
                int rmd = entry.getValue()%2;
                entry.setValue(rmd);
            }
        }
        
         for(Map.Entry<Character,Integer>  entry: map.entrySet())
        {
            if(entry.getValue()>=1)
            {
                l+=1;
                break;
            }
        }
        return l;
    }
}