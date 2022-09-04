//O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            //System.out.println(mid);
            if( (mid == 0 || nums[mid-1] <= nums[mid]) && (mid==nums.length-1 || nums[mid+1]<=nums[mid]))
               {
                   return mid;
               }
               else if(mid>0 && nums[mid-1] > nums[mid]){
                   end = mid-1;
               }
               else{
                   start = mid+1;
               }
        }
        return -1;
    }
}
O(n)
   class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i<nums.length-1; i++)
        {
           if(nums[i] > nums[i+1])
           {
               return i;
           }
        }
        return nums.length-1;
    }
}
