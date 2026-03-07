class Solution {
    public void duplicateZeros(int[] arr) {
        int i=0;
        
        
        for(int j=0; j<arr.length; j++)
        {
            if(arr[j]==0 && i==0)
            {
                if(j+1<arr.length)
                {
                    
                    putValuesToArr(j+1, arr);
                    i=1;
                }
                
            }
            else
            {
                i=0;
                
            }
        }
    }
    
    private void putValuesToArr(int index, int[] arr)
    {
        int temp = 0;
        for(int i=arr.length-1; i>index; i--)
        {
            if(i>0)
            arr[i] = arr[i-1];
        }
        arr[index] = 0;
    }
} 