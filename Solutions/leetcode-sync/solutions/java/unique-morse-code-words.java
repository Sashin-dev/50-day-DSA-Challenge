class Solution {
    String[] morseWord = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
   
        
        if(words.length<=1)
        {
            return words.length;
        }
        
         Set<String> set = new HashSet<>(); 
        for(String word : words)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<word.length(); i++)
            {
                sb.append(morseWord[word.charAt(i)-'a']);
                if(i+1==word.length())
                {
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
        
    }
}