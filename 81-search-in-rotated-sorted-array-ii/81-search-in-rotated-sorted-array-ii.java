class Solution {
    public boolean search(int[] nums, int target) {
        int m, l = 0, r = nums.length-1;
        while(l<=r)
        {
            m = (l+r)>>1;
            if(nums[m] == target)
            {
                return true;
            }
             if((nums[m]==nums[l])&&(nums[m]==nums[r]))
            {   ++l;
                --r;
            }
            else if(nums[m]>=nums[l])
            {
                if((nums[l]<=target)&&(nums[m]>target))
                    r=m-1;
                else 
                    l=m+1;
            }
            else{
                if((nums[m]<target)&&nums[r]>=target)
                    l=m+1;
                else 
                    r=m-1;
            }
        }
        return false;
    }
}