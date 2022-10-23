class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] a = new int[2];
        Map<Integer, Integer> list = new HashMap<>();
         Map<Integer, Integer> list1 = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            list.put(nums[i], list.getOrDefault(nums[i], 0) + 1);
        }
         for(int i = 0; i<n; i++)
        {
            list1.put(i+1, list1.getOrDefault(i+1, 0) + 1);
        }
        System.out.println(list);
        System.out.println(list1);
         for (Map.Entry<Integer,Integer> entry : list.entrySet()) 
         {
             if(entry.getValue() > 1)
             {
                 a[0] = entry.getKey();
             }
         }
         for (Map.Entry<Integer,Integer> entry : list1.entrySet()) 
         {
             if(!list.containsKey(entry.getKey()))
             {
                 a[1] = (int)entry.getKey();
             }
         }
        return a;
    }
}