class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] seen = new boolean[m][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x=0, y=0, di=0;
        
        List<Integer> answers = new ArrayList(m*n);
        
        for(int i=0; i<m*n; i++)
        {
            answers.add(matrix[x][y]);
            seen[x][y]=true;
            
            int cr = x + dr[di];
            int cc = y + dc[di];
            
            if(cr>=0 && cr<m && cc>=0 && cc<n && !seen[cr][cc])
            {
                
                x= cr;
                y= cc;
            }
            else
            {
                di = (di+1) % 4;
                x+=dr[di];
                y+=dc[di];
            }
        }
        
        return answers;
    }
}