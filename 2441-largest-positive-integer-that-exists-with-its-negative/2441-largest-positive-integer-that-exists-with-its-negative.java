class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
         int max1 = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(-nums[i]))
            {
                if(max < Math.abs(nums[i]))
                {
                    max = Math.abs(nums[i]);
                }
            }
            map.put(nums[i], 0);
        }
        if(max != max1)
        return max;
        return -1;
    }
}