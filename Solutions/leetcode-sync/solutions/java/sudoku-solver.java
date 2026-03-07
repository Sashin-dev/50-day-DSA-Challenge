class Solution {
    char kEmptyEntry='.';
    public void solveSudoku(char[][] board) {
        solvePartialSudoku(board, 0, 0);
    }
    
    private boolean solvePartialSudoku(char[][]board, int i, int j)
    {
        if(i==board.length)
        {
            i=0;
            if(++j==board[i].length)
            {
                return true;
            }
        }
        
        if(board[i][j]!='.')
        {
            return solvePartialSudoku(board, i+1, j);
        }
        
        for(int val=1; val<=board.length; val++)
        {
            if(validToAddVal(i, j, board, val))
            {
                board[i][j]= (char)( val + '0');
                if(solvePartialSudoku(board, i+1, j))
                {
                    return true;
                }
            }
        }
        
        board[i][j]=kEmptyEntry;
        return false;
    }
    
    private boolean validToAddVal(int i, int j, char[][] board, int val)
    {
        for(int k=0; k < board.length; k++)
        {
            if(val==board[k][j]-'0')
            {
                return false;
            }
        }
        
         for(int k=0; k < board.length; k++)
        {
            if(val==board[i][k]-'0')
            {
                return false;
            }
        }
        
        int regionSize = 3;
        int I = i/regionSize, J= j/regionSize;
        
        for(int a=0; a<regionSize; a++)
        {
            for(int b=0; b<regionSize; b++)
            {
                if(val==board[regionSize*I +a][regionSize*J+b]-'0')
                {
                    return false;
                }
            }
        }
        return true;
    }
}