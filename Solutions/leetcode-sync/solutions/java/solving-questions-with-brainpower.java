class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp, 0);

        for(int i = questions.length-1; i>=0; i--)
        {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower+1;
            long nextPoints = questions.length < nextIndex ? 0 : dp[nextIndex];
            dp[i] = Math.max( points + nextPoints, dp[i+1]);
        }
        return dp[0];
    }
}