class Solution {
    public long minimumMoney(int[][] transactions) {
        long v =0;
        long ans = 0;
        for(int[] t : transactions)
        {
            v = Math.max(v, Math.min(t[0], t[1]));
            ans +=Math.max((t[0]-t[1]), 0);
        }
        return ans + v;
    }
}