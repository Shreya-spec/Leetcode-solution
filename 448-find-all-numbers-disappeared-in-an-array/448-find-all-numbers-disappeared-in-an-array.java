class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         HashSet<Integer> hs = new HashSet();
        List<Integer>  list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++)
        {
            if(!hs.contains(i))
            {
                list.add(i);
            }
        }
        return list;
		
		

    }
}