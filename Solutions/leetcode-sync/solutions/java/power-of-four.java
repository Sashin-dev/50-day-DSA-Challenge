class Solution {
      public boolean isPowerOfFour(int n) {
        double x = Math.log(n)/Math.log(4);
        int y = (int)Math.floor(x);
        if((n > 0 && Math.pow(4,y) == n) || n == 1) 
        {
            return true;
        }
        return false;
    }
}