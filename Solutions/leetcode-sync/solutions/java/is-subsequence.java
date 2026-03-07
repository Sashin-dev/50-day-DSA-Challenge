class Solution {
    public boolean isSubsequence(String s, String t) {
        int subsequence=0;

        if(s.length()==0) return true;

        if(t.length()==0) return false;

        for(int i=0; i< t.length(); i++)
        {
            if(subsequence+1<=s.length() && subsequence<=t.length() && s.charAt(subsequence)==t.charAt(i))
            {
                subsequence+=1;
            }
        }
        return subsequence==s.length();
    }
}