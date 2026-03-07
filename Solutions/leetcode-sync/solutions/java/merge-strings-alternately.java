class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length1 = word1.length();
        int length2= word2.length();
        int firstVisited=0;
        int secondVisited=0;
        
        while(firstVisited< length1 || secondVisited < length2)
        {
                if(firstVisited< length1)
                {
                    sb.append(word1.charAt(firstVisited++));
                }
               if(secondVisited< length2)
                {
                    sb.append(word2.charAt(secondVisited++));
                }
        }
        
        return sb.toString();
    }
}