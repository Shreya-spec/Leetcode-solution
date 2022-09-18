class Solution {
    
        public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid = start + (end - start) / 2;
        
        while (start < end)
        {
            mid = start + (end - start) / 2;
            System.out.println(mid);
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        
        return nums[end];
    
    }
}