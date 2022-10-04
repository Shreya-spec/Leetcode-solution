class Solution {
    public int deleteString(String s) {
        int[][] lcs = new int[s.length()+1][s.length()+1];
        int[] dp = new int[s.length()];
        for(int i=s.length()-1;i>=0;i--){
            dp[i] = 1;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    lcs[i][j] = lcs[i+1][j+1]+1;
                }
                if(lcs[i][j] >= j-i){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[0];
    }
}