class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int[] checkCols = {0, 1, 0, -1};
    int[] checkRows = {-1, 0, 1, 0};

    int initColor = image[sr][sc];
    int [][] ans = image;

    dfs(image, ans, initColor, checkCols, checkRows, sr, sc, color);
    return ans;
    }

    public void dfs(int[][] image, int[][]ans, int initColor, 
    int[] checkCols, int [] checkRows, int row, int col, int color)
    {
        ans[row][col] = color;
        int totalRows = image.length;
        int totalCols = image[0].length;

        for(int i=0; i<4; i++)
        {
            int currRow = row + checkRows[i];
            int currCol = col + checkCols[i];

            if(currRow>=0 && currCol>=0 && currRow<totalRows
            && currCol < totalCols && image[currRow][currCol]== initColor
            && ans[currRow][currCol]!=color)
            {
                dfs(image, ans, initColor, checkCols, checkRows, currRow,
                 currCol, color);
            }
        }
    }
}