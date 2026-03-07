class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue(stones.length, Collections.reverseOrder());
        for(int i=0; i<stones.length; i++)
        {
            queue.add(stones[i]);
        }
        
        while(queue.size()>0)
        {
            if(queue.size()==1)
            {
                return queue.peek();
            }
            
            int a = queue.peek();
            queue.poll();
            
            int b = queue.peek();
            queue.poll();
            if(a>b)
            {   
                queue.add(Math.abs(a-b));
            }
            
        }
        
        return 0;
    }
}