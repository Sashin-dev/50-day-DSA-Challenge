class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] response = new int[2];
        int left=0, right = numbers.length-1;
        while(left<right){
            int sum= numbers[left]+numbers[right];
            if(sum==target){
                response[0] = left+1;
                response[1] = right+1;
                break;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return response;
    }
}