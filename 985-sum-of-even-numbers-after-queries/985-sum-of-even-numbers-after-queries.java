class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int m = 0;
        int sum = 0;
        for(int j = 0; j<nums.length; j++)
            {
                if(nums[j]%2 == 0)
                {
                   sum+=nums[j]; 
                }
            }
      
        for(int i = 0; i<queries.length; i++)
        {
            System.out.println(nums[queries[i][1]]+"before");
            if(nums[queries[i][1]]%2 == 0)
            {
                sum = sum - nums[queries[i][1]];
            }
            nums[queries[i][1]] = nums[queries[i][1]] + queries[i][0];
            System.out.println(nums[queries[i][1]]+"after");
            if(nums[queries[i][1]]%2 == 0)
            {
               sum = sum + nums[queries[i][1]]; 
            }
            
                   ans[i]+=sum;
                
            
        }
         /*for(int j = 0; j<nums.length; j++)
            {
             System.out.print(nums[j] +" ");
         }
         System.out.println*/
        
        return ans;
    }
}