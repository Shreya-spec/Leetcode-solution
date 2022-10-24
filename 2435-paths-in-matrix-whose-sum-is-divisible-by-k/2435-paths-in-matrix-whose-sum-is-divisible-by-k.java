class Solution {
   int mod = (int) (Math.pow(10,9) + 7);
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int[][] n :dp)
        {
            for(int[] m : n)
            {
                 Arrays.fill(m, -1);
            }
        }
       
        return fnc(grid, k , 0 , 0 , 0, dp);
    }
    public int fnc(int[][] grid, int k, int i , int j , int sum, int[][][] dp)
    {
        //base code
        if( i < 0 || j < 0 || i>=grid.length || j>=grid[0].length)
        {
            return 0;
        }
        //end cell
        if((i == grid.length -1) && (j == grid[0].length-1))
        {
            sum +=grid[i][j];
            if(sum%k == 0) return 1;
            return 0;
        }
        if(dp[i][j][sum%k]!= -1) return dp[i][j][sum%k];
        long down = fnc(grid, k , i+1, j, sum + grid[i][j], dp);
        long right = fnc(grid, k , i , j+1, sum+grid[i][j], dp);
        return dp[i][j][sum%k] = (int)((down%mod + right%mod))%mod;
    }
}