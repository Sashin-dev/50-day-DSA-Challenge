class Solution {
    public int[][] generateMatrix(int n) {
        
        int size= (int) Math.ceil(0.5 * (n+1));
        int[][] matrix = new int [n][n];
        int counter=1;
        for (int offset=0; offset<size; offset++)
        {
          counter=  spiralAndPutVal(offset, matrix, counter);
        }
        
        return matrix;
    }
    
    private int spiralAndPutVal(int offset, int[][] matrix, int counter )
    {
      if(offset==matrix.length-offset-1)
      {
          matrix[offset][offset] = counter++;
          return counter;
      }

      for(int i=0; i < matrix.length-offset-1; i++)
      {
          if(matrix[offset][i] == 0)
          {
              matrix[offset][i]=counter++;
          }
      }

    for(int i=0; i<matrix.length-1-offset; i++)
    {
        if(matrix[i][matrix.length-offset-1]==0)
        {
            matrix[i][matrix.length-offset-1]=counter++;
        }
    }


    for(int i=matrix.length-1-offset; i>0; i-- )
    {
        if(matrix[matrix.length-offset-1][i]==0)
        {
            matrix[matrix.length-offset-1][i]=counter++;
        }
    }

    for(int i=matrix.length-1-offset; i>0; i-- )
    {
        if(matrix[i][offset]==0)
        {
            matrix[i][offset]=counter++;
        }
    }
    return counter;
    }

}