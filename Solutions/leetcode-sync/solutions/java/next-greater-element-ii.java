class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] response = new int[n];
        Arrays.fill(response, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<2*n-1; i++){
            int index = i%n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                response[stack.pop()] = nums[index];
            }
            stack.push(index);
        }

        return response;
    }
}