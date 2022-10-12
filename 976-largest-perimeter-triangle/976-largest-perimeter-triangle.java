class Solution {
    public int largestPerimeter(int[] nums) {
          //Sort the array first.
        Arrays.sort(nums);
        
      
        for(int i = nums.length-1; i>1; i--){
           if(nums[i] < nums[i-1] + nums[i-2])
               return  nums[i] + nums[i-1]+ nums[i-2];   
        }
        
        
        return 0;
    }
}