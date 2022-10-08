class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0]+nums[1]+nums[nums.length-1];
        for(int i =0;i<nums.length-2;i++)
        {
            int lo = i +1, hi = nums.length-1;
            int temp =0;
            while(lo<hi)
            {
                temp=nums[i]+nums[lo]+nums[hi];
                if(temp>target)
                {
                    hi--;
                }
                else lo++;
                if(Math.abs(sum-target)>Math.abs(temp-target))
                {
                    sum=temp;
                }
            }
        }
       return sum;     
    }
}