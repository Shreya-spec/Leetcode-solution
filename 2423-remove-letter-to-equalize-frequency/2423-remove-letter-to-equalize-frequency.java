class Solution {
    public boolean equalFrequency(String word) {
        char[] temp = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i<temp.length; i++)
        {
            if(map.containsKey(temp[i]))
            {
            map.put(temp[i], (map.get(temp[i]))+1);
                }
            else
            {
                map.put(temp[i], 1);
            }
        }
         for (Map.Entry<Character,Integer> entry : map.entrySet()) 
        {
            int val = 0;
            Set<Integer> set = new HashSet<>();
             for(Map.Entry<Character,Integer> entry1 : map.entrySet()) 
            {
                if(entry.getKey() == entry1.getKey()){
                    if(((entry.getValue())-1) > 0)
                    {
                        set.add(entry.getValue()-1);
                    }
                    continue;
                }
                 set.add(entry1.getValue());
            }
             if(set.size() == 1)
             {
                 return true;
             }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) 
        {
            if(entry.getValue() == 1)
            {
                cnt++;
            }
        }
        if(cnt == word.length())
        {
            return true;
        }
        return false;
    }
}