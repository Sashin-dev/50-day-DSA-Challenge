class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<String, Character> map = new HashMap();
        if(words.length!=pattern.length())
        {
            return false;
        }

        String[] strArr = new String[256];
        Arrays.fill(strArr, "");
        int counter=0;
        for(char c : pattern.toCharArray())
        {
            if(strArr[c].length()==0)
            {
                strArr[c] = words[counter];
                if(!map.containsKey(words[counter]))
                {
                    map.put( words[counter++], c);
                }
                else if(map.getOrDefault(words[counter], ' ')!=c)
                {
                    // System.out.println("C: "+ c + " word: "+ words[counter]);
                    return false;
                }
                
                
            }
            else if(!strArr[c].equals(words[counter++]) )
            {
                counter++;
                //  System.out.println("C: "+ c);
                return false;
            }
        }
        return true;
    }
}