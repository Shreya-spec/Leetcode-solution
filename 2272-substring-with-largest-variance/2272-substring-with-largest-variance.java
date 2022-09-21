class Solution {
    public int largestVariance(String s) {
        
        int res = 0;
        
        //we will take every a-z pair as-> high and low
        //we will use kadanes to maximize freq of high in window
        //eg high=a, low=b, we will also calculate when high=b, low=a
        for(int high=0;high<26;high++){ 
            for(int low=0;low<26;low++){
                if(high==low) continue;  //if both are same ignore
                
                int currHigh=0, currLow=0;
                boolean windowShrinked = false;
                for(int i=0; i<s.length(); i++){
                    int ch = s.charAt(i)-'a';
                    if(ch == high) currHigh++;
                    else if(ch == low) currLow++;
                    
                    if(currHigh>0 && currLow>0){
                        res = Math.max(res, currHigh-currLow);
                    }
                    // abb'aaaaaa' when we know window is shrinked, count of currLow can be 0 
                    //but we can consider it as 1 bcz it occured once
                    else if(currHigh>0 && windowShrinked){ 
                        res = Math.max(res, currHigh-1);
                    }
                    
                    //if count of low becomes more than high(our window have more 'low' elements which we dont want)
                    //so we reduce the size of window and set currLow and currHigh as 0;
                    //abbaaaaaa (a=high, b=low) when second b comes, count of low becomes more so we neglect abb
                    //but we may take last b into consideration in above case
                    if(currLow>currHigh){ //window shrinked 
                        windowShrinked = true;
                        currLow = 0;
                        currHigh = 0;
                    }
                }
            }
        }
        
        return res;
    }
}