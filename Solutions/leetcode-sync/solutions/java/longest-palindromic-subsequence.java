class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb= new StringBuilder(s).reverse();
        String sRev = sb.toString();

        int length= s.length();
        int[][] dp = new int [length][length];
        for(int rows[] : dp)
        {
            Arrays.fill(rows, -1);
        }
        return lcs(s, sRev, length-1, length-1, dp);
    }

    public int lcs(String s1, String s2, int i1, int i2, int[][] dp)
    {

        if(i1<0 || i2<0)
        {
            return 0;
        }
        if(dp[i1][i2]!=-1)
        {
            return dp[i1][i2];
        }

        if(s1.charAt(i1)==s2.charAt(i2))
        {
            return dp[i1][i2] =  1 + lcs(s1, s2, i1-1, i2-1, dp);
        }

        return dp[i1][i2] = 0 + Math.max( lcs(s1, s2, i1-1, i2, dp),
                                        lcs(s1, s2, i1, i2-1, dp));
    }
}