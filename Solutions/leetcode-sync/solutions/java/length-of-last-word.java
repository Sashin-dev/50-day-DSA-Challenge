class Solution {
    public int lengthOfLastWord(String s) {
     int i  = s.length()-1;

     while(s.charAt(i)== ' ')
     {
         i-=1;
     }

     int n=0;
     while(i>=0 && s.charAt(i)!=' ')
     {
         n+=1;
         i-=1;
     }
     return n;
    }
}