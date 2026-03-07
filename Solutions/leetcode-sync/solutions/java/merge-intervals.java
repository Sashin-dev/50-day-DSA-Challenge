class Solution {
    public int[][] merge(int[][] nums) {
        List<int[]> responseList = new ArrayList<>();

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        // --- NEW: start with the first interval as the current merged interval
        int currentStart = nums[0][0];
        int currentEnd = nums[0][1];

        // start from i = 1, try to merge each interval into [currentStart, currentEnd]
        for (int i = 1; i < nums.length; i++) {
            int start = nums[i][0];
            int end = nums[i][1];

            if (start <= currentEnd) {
                // overlap -> extend current interval
                currentEnd = Math.max(currentEnd, end); // CHANGED: use max end, not nums[i][1] blindly
            } else {
                // no overlap -> flush current and start a new interval
                responseList.add(new int[] { currentStart, currentEnd }); // CHANGED: add merged [currentStart,currentEnd]
                currentStart = start;
                currentEnd = end;
            }
        }

        // --- NEW: flush the last running interval
        responseList.add(new int[] { currentStart, currentEnd });

        int[][] ans = new int[responseList.size()][2];
        for (int i = 0; i < responseList.size(); i++) {
            ans[i] = responseList.get(i);
        }
        return ans;
    }
}
