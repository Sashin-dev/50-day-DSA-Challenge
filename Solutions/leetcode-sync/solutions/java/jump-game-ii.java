class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // best we can reach from this range

            if (i == currentEnd) { // end of current jump's coverage
                jumps++; // must do a new jump
                currentEnd = farthest; // extend to best we’ve seen so far
            }
        }

        return jumps;

    }
}