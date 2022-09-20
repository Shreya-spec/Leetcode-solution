class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int si = 0; si<nums.length; si++)
        {
            long max = nums[si];
            long min = nums[si];
            for(int  ei = si+1; ei<nums.length; ei++)
            {
                max = Math.max(max, nums[ei]);
                min = Math.min(min, nums[ei]);
                sum+=(max-min);
            }
        }
        return sum;
    }
}