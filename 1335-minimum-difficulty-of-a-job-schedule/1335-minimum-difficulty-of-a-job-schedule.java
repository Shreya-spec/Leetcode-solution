class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length) return -1;
        int[][] dp = new int[d+1][jobDifficulty.length];
        for(int[] p : dp)
        {
            Arrays.fill(p, -1);
        }
        return dfs(jobDifficulty, d, dp, 0);
    }
    private int dfs(int[] jobDifficulty, int d, int[][] dp, int idx)
    {
        if(d == 1)
        {
            int max = 0;
            while(idx < jobDifficulty.length){
                max = Math.max(max, jobDifficulty[idx++]);
            }
            return max;
        }
        if(dp[d][idx] != -1) return dp[d][idx];
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int i = idx; i<jobDifficulty.length-d+1; i++)
        {
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max + dfs(jobDifficulty, d-1, dp, i+1));
        }
        return dp[d][idx] = res;
    }
}