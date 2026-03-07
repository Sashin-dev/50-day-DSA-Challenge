class Solution {
    public int[] plusOne(int[] digits) {
        int[] modifiedDigitsArr = null;
        for(int i=digits.length-1; i>=0; i--)
        {
            if(digits[i]+1>9){
                digits[i]=0;
                if(i==0){
                    modifiedDigitsArr = new int[digits.length+1];
                    System.arraycopy(digits, 0, modifiedDigitsArr, 1, digits.length);
                    modifiedDigitsArr[0]=1;
                }
            }
            else{
                digits[i]+=1;
                break;
            }
        }
        return modifiedDigitsArr==null ? digits : modifiedDigitsArr;
    }
}