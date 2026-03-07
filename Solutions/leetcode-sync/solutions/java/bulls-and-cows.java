class Solution {
    public String getHint(String secret, String guess) {
        
        int countBulls=0;
        int countCows =0;
        Map< Character, Integer> secretMap = new HashMap<>(10);
        Map< Character, Integer> guessMap = new HashMap<>(10);
        
        for(int i=0; i< guess.length(); i++)
        {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);
            
            
            if(secret.charAt(i)==guess.charAt(i))
            {
                ++countBulls;
            }else
            {
                secretMap.put(secretChar, secretMap.getOrDefault(secretChar, 0)+1);
                guessMap.put(guessChar, guessMap.getOrDefault(guessChar, 0)+1);
            }
          
        }
        
      
        for(Map.Entry<Character, Integer> entry: secretMap.entrySet())
        {
            Character secVal = entry.getKey();
            if(guessMap.getOrDefault(secVal, 0)>0)
            {
                int incr = Math.min(entry.getValue(),guessMap.get(secVal)) ;
                countCows+= incr;
            }
            
        }
        
        return new StringBuilder(countBulls+"").append("A").append( countCows).append( "B").toString();
    }
}