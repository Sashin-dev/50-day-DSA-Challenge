class Solution {
    public boolean isValidSudoku(char[][] board) {
       
       //check the rows
       for(int i=0; i<9; i++)
       {
           if(!isValid(i, i+1, 0, 9, board))
           {
               return false;
           }
       }

       //check the cols
       for(int i=0; i<9; i++)
       {
           if(!isValid(0, 9,i, i+1, board))
           {
               return false;
           }
       }

       //check the sub grids
       for(int i=0; i<3; i++)
       {
           for(int j=0; j<3; j++)
       {
           if(!isValid(i*3, (i+1)*3, j*3, 3* (j + 1), board))
           {
               return false;
           }
       }
       }

       return true;
       
       
}

    private boolean isValid(int rowS, int rowE, int colS, int colE, char[][] board)
    {

        Map<Character, Integer> map = new HashMap();

        for(int i=rowS; i<rowE; i++)
        {
            for(int j= colS; j<colE; j++)
            {
                if(board[i][j]!='.')
                {
                    if(map.containsKey(board[i][j]))
                    {
                        return false;
                    }
                    map.put(board[i][j], 1);
                }
            }
        }
        return true;
    }

}