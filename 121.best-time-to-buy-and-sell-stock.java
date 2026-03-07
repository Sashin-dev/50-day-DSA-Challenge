/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfitSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minPrice);
        }
        return maxProfitSoFar;
    }
}
// @lc code=end
