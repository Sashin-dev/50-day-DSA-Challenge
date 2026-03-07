class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1)
        {
            return 0;
        }
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        int count=0;
        for(int p=2; p<n ;p++)
        {
            if(isPrime[p])
            {
                ++count;
                
                for(int j=p; j<=n; j+=p)
                {
                    isPrime[j]=false;
                }
            }
        }
        return count;
    }
}