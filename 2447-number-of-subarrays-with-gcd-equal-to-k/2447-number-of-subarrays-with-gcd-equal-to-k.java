class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i<nums.length; i++)
        {
            int factor = nums[i];
            for(int j = i; j<nums.length; j++)
            {
               factor = getgcd(factor,nums[j]);
                System.out.println(factor);
                if(factor == k)
                {
                    count++;
                }
                if(factor< k)
                {
                    break;
                }
            }
        }
        return count;
    }
   public int getgcd(int a, int b) {
        if (b == 0)
            return a;
        return getgcd(b, a % b);
    }

}