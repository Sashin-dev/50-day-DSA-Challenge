class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] response = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                response[idx] = i - idx;
            }
            stack.push(i);
        }
        return response;
    }
}