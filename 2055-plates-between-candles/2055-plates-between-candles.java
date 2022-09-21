class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] nearestCandleToLeft = new int[len];
        int[] nearestCandleToRight = new int[len];
        int[] plates = new int[len];
        
        int ncl = -1;
        if(s.charAt(0)=='*') plates[0]=1;
        for(int i=0;i<len;i++){
		    // if plate, maintain cumulative sum
            if(s.charAt(i)=='*'){
                nearestCandleToLeft[i]=ncl;
                if(i!=0) plates[i]=plates[i-1]+1;
            }else {
                nearestCandleToLeft[i]=i;
                ncl = i;
                if(i!=0) plates[i]=plates[i-1];
            }
        }
        
        int ncr = Integer.MAX_VALUE;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)=='|')
                ncr=i; 
            nearestCandleToRight[i]=ncr;
        }
        
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ncr = nearestCandleToRight[queries[i][0]];
            ncl = nearestCandleToLeft[queries[i][1]];
            if(ncl < queries[i][0] || ncr > queries[i][1]){
                ans[i]=0;
                continue;
            }
            ans[i]=plates[ncl]-plates[ncr];
        }
        return ans;
    }
}