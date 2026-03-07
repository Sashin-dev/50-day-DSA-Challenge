class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i1= text1.length();
        int i2= text2.length();
        int dp[][] = new int[i1][i2];

        for(int rows[]: dp)
        {
            Arrays.fill(rows, -1);
        }
        return lcs(text1, text2, i1-1, i2-1, dp);

    }

    public int lcs(String text1, String text2, int i1, int i2, int[][] dp)
    {
            if(i1<0|| i2<0)
            {
                return 0;
            }

            if(dp[i1][i2]!=-1)
            {
                return dp[i1][i2];
            }
            if(text1.charAt(i1)==text2.charAt(i2))
            {
                return dp[i1][i2]= 1 + lcs(text1, text2, i1-1, i2-1, dp);
            }
            return dp[i1][i2] = Math.max(lcs(text1, text2, i1-1, i2, dp), 
                            lcs(text1, text2, i1, i2-1, dp));
    }
}