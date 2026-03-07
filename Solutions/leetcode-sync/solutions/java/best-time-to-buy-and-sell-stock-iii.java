class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[] firstBuySellProfits = new int[prices.length];
        
        for(int i=0; i<prices.length; i++)
        {
            max = Math.max(max, prices[i]-min);
            min = Math.min(min, prices[i]);
         
            firstBuySellProfits[i] = max;
        }
        
       // System.out.println(Arrays.toString(firstBuySellProfits));
        Integer maxPriceSoFar = Integer.MIN_VALUE;
        for(int i = prices.length-1; i>0; --i)
        {
            maxPriceSoFar= Math.max(maxPriceSoFar, prices[i]);
            max = Math.max(max, maxPriceSoFar-prices[i]+firstBuySellProfits[i-1]);
        }
        return max;
    }
}