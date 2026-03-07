class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitSoFar=Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        // int maxPrice = 
        for(int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfitSoFar = Math.max(maxProfitSoFar, prices[i]-minPrice);
        }
        return maxProfitSoFar;
    }
}