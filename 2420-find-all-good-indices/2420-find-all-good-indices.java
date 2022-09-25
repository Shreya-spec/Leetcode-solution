class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 1;
        for(int i = 1; i<n; i++)
        {
            if(nums[i-1]>=nums[i])
            {
                a[i] = a[i-1] + 1;
            }
            else
            {
                a[i] = 1;
            }
           // System.out.println(a[i]);
        }
        b[n-1] = 1;
        for(int i = n-2; i>=0; i--)
        {
            if(nums[i+1]>=nums[i])
            {
                b[i] = b[i+1] + 1;
            }
            else
            {
                b[i] = 1;
            }
            //System.out.println(b[i]);
        }
        /*for(int i = 0; i<n; i++)
        {
            //System.out.print(b[i]);
        }
        System.out.println(" ");
        for(int i = 0; i<n; i++)
        {
            System.out.print(a[i]);
        }*/
        
        for(int i = k; i<n-k; i++)
        {
            if(b[i+1]>=k)
            {
                if(a[i-1]>=k)
                {
                    list.add(i);
                }
            }
        }
        return list;
    }
}