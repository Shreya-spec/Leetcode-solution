class Solution {
    public int shortestPath(int[][] grid, int k) {     
        int row = grid.length-1;
        int col = grid[0].length-1;
        
        // if all obstacles can be eliminated
        if(k >= row + col) {
            return row + col;
        }
        
        //Memoization in 5 steps
		
		// #1 : take an array to store results
        int[][][] memo = new int[row+1][col+1][k+1];
		
		// #2 : initialize it with Integer Max value
        Arrays.stream(memo).forEach(mat -> Arrays.stream(mat).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE))); 
        
		// #3 : pass memo to recursive function
        int shortestPathDistance = dfs(grid, 0, 0, k, memo);
        return shortestPathDistance == Integer.MAX_VALUE ? -1 : shortestPathDistance;
    }
    
    private int dfs(int[][] grid, int i, int j, int k, int[][][] memo) { 
        
        // out of grid boundary or already visited
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return Integer.MAX_VALUE-1;   // -1, to avoid Integer overflow 
        }
        
        // reach to destiantion (bottom right corner)
        if(i == grid.length-1 && j == grid[0].length-1) {
            return 0;
        }
        
        // #4 : return result if already stored in memo to avoid recomputaion
        if(memo[i][j][k] != Integer.MAX_VALUE) {
            return memo[i][j][k];
        }
        
        // if all obstacles can be eliminated
        if(k >= (grid.length-1-i + grid[0].length-1-j)) {
            return memo[i][j][k] = (grid.length-1-i + grid[0].length-1-j);
        }
        
        // hit obstacles, if it can be eliminate then continue o/w return 
        if(grid[i][j] == 1 && k-- <= 0) {
            return Integer.MAX_VALUE-1;
        }
        
        int temp = grid[i][j]; 
        grid[i][j] = -1; // mark visited
        
        // recure in all four directions
        int left = dfs(grid, i-1, j, k, memo);
        int right = dfs(grid, i+1, j, k, memo);
        
        int up = dfs(grid, i, j-1, k, memo);
        int down = dfs(grid, i, j+1, k, memo);

        grid[i][j] = temp; // undo (mark unvisited)
        
        return memo[i][j][k] = 1 + Math.min(left, Math.min(right, Math.min(up, down))); // #5 : store result & return it
    }
}