class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int steps = cost.length;
        int[] stairMinCost = new int [steps+2];
        
        stairMinCost[steps]=0;
        stairMinCost[steps+1]=0;
        
        for(int i=steps-1; i>=0; i--)
        {
            stairMinCost[i] = cost[i] + Math.min(stairMinCost[i+1], stairMinCost[i+2]) ;
        }
        
        
        
        // for(int i: stairMinCost)
        // {
        //     System.out.println(i);
        // }
        // return 1;
        return Math.min(stairMinCost[0], stairMinCost[1]);
    }
}