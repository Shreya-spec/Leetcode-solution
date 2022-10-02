class Solution {
    static final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] momo = new int[n+1][target+1];
        for(int[] t: momo)
        {
            Arrays.fill(t, -1);
        }
        return dp(n, k, target, momo);
    }
    public int dp(int n, int k, int target, int[][] momo)
    {
        if(target < 0)
            return 0;
        if(momo[n][target] != -1)
        {
            return momo[n][target];
        }
        if(n == 1)
            return target> 0 && target<=k ? 1: 0;
        int totalWays = 0;
        for(int i = 1; i<=k; i++)
        {
            totalWays = (totalWays + dp(n-1, k, target-i, momo)) % MOD;
        }
        momo[n][target] = totalWays;
        return totalWays;
    }
}