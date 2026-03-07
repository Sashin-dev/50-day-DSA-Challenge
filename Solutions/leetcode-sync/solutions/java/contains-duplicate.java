class Solution {
    public boolean containsDuplicate(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        return count!=nums.length;
    }
}