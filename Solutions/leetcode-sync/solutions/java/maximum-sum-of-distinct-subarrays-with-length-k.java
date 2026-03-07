class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // 1) Use long for sums
        long currentSum = 0;
        int left = 0;
        int right = 0;
        long maxSum = 0; // changed to long
        Set<Integer> set = new HashSet<>();

        // 2) Condition uses strict < nums.length (safer pattern)
        while (right < nums.length) {

            // 3) If duplicate, shrink from left UNTIL it's gone
            while (set.contains(nums[right])) { // changed: was single if
                currentSum -= nums[left]; // changed: update sum while shrinking
                set.remove(nums[left]);
                left++;
            }

            // 4) Add new element
            currentSum += nums[right]; // unchanged line but now always after duplicate removal
            set.add(nums[right]);
            right++;

            // 5) If window too big, shrink from left
            while (right - left > k) { // changed: enforce exact window size
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            // 6) When window size is exactly k, update max
            if (right - left == k) { // unchanged condition, but now window is clean
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
