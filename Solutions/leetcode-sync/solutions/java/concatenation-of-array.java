class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] response = new int[2 * nums.length];
        System.arraycopy(nums, 0, response, 0, nums.length);
        System.arraycopy(nums, 0, response, nums.length, nums.length);
        //System.out.println(response);
        return response;
    }
}