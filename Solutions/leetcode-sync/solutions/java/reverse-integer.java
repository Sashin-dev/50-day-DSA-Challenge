class Solution {
    public int reverse(int x) {
        if(x==0)
        {
            return 0;
        }
        
       
        long reverse=0;
        int reminder=0;
        
        
        while(x!=0)
        {
            reminder = x%10;
            reverse = reverse*10+reminder;
            x=x/10;
        }
        if(reverse > Integer.MAX_VALUE || reverse< Integer.MIN_VALUE)
        {
            return 0;
        }
        return (int)reverse;
    }
}