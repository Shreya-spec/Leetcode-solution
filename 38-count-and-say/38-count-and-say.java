class Solution {
    public String countAndSay(int n) {
        if(n<=0){
            System.out.println("Invalid Output");
        }
        StringBuilder sb = new StringBuilder("1");
        for(int i = 2; i<=n; i++)
        {
            sb = getNextState(sb);
        }
        return sb.toString();
        
    }
    public StringBuilder getNextState(StringBuilder cursb)
    {
        StringBuilder nextSb = new StringBuilder();
        int len = cursb.length();
        int i = 0;
        while(i<len)
        {
            char c = cursb.charAt(i++);
            int count = 1;
            while(i <len && c== cursb.charAt(i)){
                count++;
                i++;
            }
            nextSb.append(count).append(c);
        }
        return nextSb;
    }
}