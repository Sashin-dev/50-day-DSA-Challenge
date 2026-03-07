class NumArray {

    int [] prefixArr;
    public NumArray(int[] nums) {
        this.prefixArr = new int[nums.length+1];
        for(int i=0; i<nums.length;i++){
            prefixArr[i+1] = prefixArr[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixArr[right+1] - prefixArr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */