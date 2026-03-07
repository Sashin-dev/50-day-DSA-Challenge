class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // sum of first window [0..k-1]
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // slide window: each step add right, remove left
        for (int i = k; i < n; i++) {
            sum += nums[i];          // add new element
            sum -= nums[i - k];      // remove element leaving window
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
