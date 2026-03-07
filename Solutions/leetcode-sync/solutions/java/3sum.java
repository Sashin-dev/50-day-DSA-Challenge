class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3)
            return list;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // 1) Skip duplicate i's to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > 0)
                break;

            int currSum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            // 2) Simplify condition to just left < right
            while (left < right) {
                int iterSum = nums[left] + nums[right];

                if (iterSum == currSum) {
                    // 3) Use (i, left, right) in sorted order
                    list.add(List.of(nums[i], nums[left], nums[right]));

                    // 4) Move left and right past duplicates
                    int leftVal = nums[left++];
                    int rightVal = nums[right--];

                    while (left < right && nums[left] == leftVal)
                        left++;
                    while (left < right && nums[right] == rightVal)
                        right--;
                } else if (iterSum > currSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
