class Solution {
    public int myAtoi(String s) {
        // s = s.trim();
        int index=0;
        int length = s.length();
        boolean isNegative = false;
        char[] arr = s.toCharArray();

        while(index<length && arr[index]==' ')
        {
            index++;
        }

        if(index<length){
        if(arr[index]== '-')
            {
                isNegative= true;   
                index++;
            }
            else if(arr[index]== '+')
            {
                isNegative=false;
                index++;
            }
        }
        int result= 0;
        while(index<length && isDigit(arr[index])){
            int digit = arr[index]-'0';
               if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7))
                            {
                                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                            }
            result=result*10 + digit;
            index++;
        }

        return isNegative ? (-1 * result) : (result);
    }

    private boolean isDigit(char c){
        return c >='0' && c<= '9';
    }
}