class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int count = 1;
        for(int i = 1; i<s.length(); i++)
        {
            if(s.charAt(i) - s.charAt(i-1) == 1)
            {
                count++;
                ans = Math.max(ans, count);
            }
            else
            {
                count = 1;
            }
        }
        return ans;
    }
}