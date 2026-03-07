class Solution {
    public int climbStairs(int n) {
        return climbStairsCalc(n);
    }
    
    private int climbStairsCalc(int n)
    {
        int[] store = new int [n+2];
        
        store[1]=1;
        store[2] =2;
        
        if(n==1 || n==2)
        {
            return store[n];
        }
        
        // int i=0;
        
        for(int i=3; i<=n; i++)
        {
            store[i] = store[i-1]+ store[i-2];
        }
        
        return store[n];
    }
}