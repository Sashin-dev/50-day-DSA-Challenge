class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] newArr = new int [n*2];
        int k=0;
        for(int i =0; i< (n); i++){
            newArr[k++] = nums[i];
            newArr[k++] = nums[n+i];
        }
        return newArr;
    }
}