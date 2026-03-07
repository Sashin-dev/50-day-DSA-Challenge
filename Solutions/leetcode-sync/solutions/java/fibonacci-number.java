class Solution {
    public int fib(int n) {
       return fibonacci(n) ;
    }
    
//     private int fibonacci(int n)
//     {
//         if(n==0 )
//         {
//             return 0;
//         }
        
//         if(n==1)
//         {
//             return 1;
//         }
//         return  fibonacci(n-1) + fibonacci(n-2);
//     }
    
    private int fibonacci(int n)
    {
        int[] store = new int [n+2];
        
        store[0]=0;
        store[1] =1;
        
        // int i=0;
        
        for(int i=2; i<=n; i++)
        {
            store[i] = store[i-1]+ store[i-2];
        }
        
        return store[n];
    }
}