class Solution {
    public int numMatchingSubseq(String s, String[] words) {       
        
        //modern approach
        HashMap<Character, Queue<String>> map = new HashMap<>();
        int count=0;
        for(Character c : s.toCharArray())
        {
            map.putIfAbsent(c, new LinkedList());
        }
        
        for(String word: words)
        {
            if(map.containsKey(word.charAt(0)))
            {
                map.get(word.charAt(0)).offer(word);
            }
        }
        
        for(int i=0; i<s.length(); ++i)
        {
            Character startChar = s.charAt(i);
            Queue<String> queue = map.get(startChar);
            int size= queue.size();
            for(int j=0; j<size; ++j)
            {
                String currWord = queue.poll();
                if(currWord.substring(1).length()==0)
                {
                    count++;
                }else
                {
                    if(map.containsKey(currWord.charAt(1)))
                    {
                        map.get(currWord.charAt(1)).add(currWord.substring(1));
                    }
                }
            }
        }
        
        return count;
    }
    
}