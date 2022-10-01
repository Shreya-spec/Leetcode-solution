class Solution {
    int[] months = new int[]{31, 28, 31, 30, 31,30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] a = new int[]{getVal(arriveAlice), getVal(leaveAlice)};
        int[] b = new int[]{getVal(arriveBob), getVal(leaveBob)};
        
        if(b[0]>a[1] || a[0] > b[1]) return 0;
        int start = Math.max(a[0], b[0]);
        int last = Math.min(a[1], b[1]);
        return last-start+1;
    }
    int getVal(String s){
        int idx = 0;
        int mon = (s.charAt(0) - '0')*10 + (s.charAt(1) - '0'); 
        int day = (s.charAt(3) - '0')*10 + (s.charAt(4) - '0'); 
        for(int i = 1; i<mon; i++)
        {
            idx += months[i-1];
        }
        return idx+day;
    }
}