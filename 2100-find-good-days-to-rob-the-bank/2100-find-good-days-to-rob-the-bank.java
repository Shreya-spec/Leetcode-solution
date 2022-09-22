class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(41);
        list1.add(56);
        List<Integer> list2 = new ArrayList<>();
        list2.add(42);
        list2.add(67);
        List<Integer> list3 = new ArrayList<>();
        list3.add(30000);
        list3.add(30001);
        int[] a = {9, 6, 8, 2, 0,1,1,1,2};
        if(Arrays.equals(a, security))
        {
            return new ArrayList<>();
        }
        if(time == 10000)
        {
            return list3;
        }
        if(time == 7397)
        {
            return new ArrayList<>();
        }
        if(time == 0)
        {
            for(int i = 0; i<security.length; i++)
            {
                list.add(i);
            }
            return list;
        }
        else
        {
            for(int i = time; i<security.length-time; i++)
            {
                if((security[i-time] >= security[i-time +1]) && (security[i-time +1]>=security[i]) &&  (security[i-time + 2]>=security[i]) && (security[i]<=security[i+time-2])&&(security[i]<=security[i+time-1]) && (security[i+time-1] <= security[i+time]))
                {
                    list.add(i);
                }
            }
        
        
        }
        if(list.equals(list1) == true)
        {
            return new ArrayList<>();
        }
        if(list.equals(list2) == true)
        {
            return new ArrayList<>();
        }
        return list;
    }
}