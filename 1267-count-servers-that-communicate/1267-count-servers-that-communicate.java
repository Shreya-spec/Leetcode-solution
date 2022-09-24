class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int total = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j =  0; j<m; j++)
            {
                if(grid[i][j] == 1 && (rows[i]>=2 || cols[j] >=2))
                {
                    total++;
                }
            }
        }
        return total;
    }
}