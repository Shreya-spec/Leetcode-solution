class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        int i = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        if(num == 0)
        {
            return true;
        }
        i = num/2;
        while(i<=num)
        {
            int temp = i;
            int temp1 = 0;
            if(!set.contains(i)){
                while(temp>0){
                    temp1 = temp1*10+temp%10;
                    temp/=10;
                }
                if((i + temp1) == num)
                {
                    return true;
                }
                set.add(i);
                set.add(temp1);
            }
            i++;
        }
        return false;
    }
}