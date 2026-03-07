class Solution {
    public boolean isPalindrome(int x) {
        
       
        
        return x == reverse(x);
    }
    
    public long reverse(long num)
    {
        long number = num;
        long reverse =0l;
        if(num==0)
        {
            return 0;
        }
        if(num<0)
        {
            return Math.abs(num);
        }
        
        while(number!=0)
        {
            reverse  = reverse *10+ number%10;
            number = number/10;
        }
        return reverse;
        
    }
}