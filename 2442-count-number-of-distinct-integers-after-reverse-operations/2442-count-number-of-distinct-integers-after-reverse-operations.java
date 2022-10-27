class Solution {
    public int countDistinctIntegers(int[] nums) {
        int m = nums.length;
        int[] a = new int[2*m];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++)
        {
            a[i] = nums[i];
            a[nums.length+i] = reverse(nums[i]);
        }
        for(int i = 0; i<a.length; i++)
        {
            set.add(a[i]);
        }
        return set.size();
    }
    public static int reverse(int n){
       
      int rev = 0; // reversed number
      int rem;   // remainder
       
      while(n>0){
          
        rem = n%10;
        rev = (rev*10) + rem;
        n = n/10;
      }
       
      return rev;
    }
}