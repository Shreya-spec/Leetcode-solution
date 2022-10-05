class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int xor = 0;
        if(m%2 == 0 && n%2 == 0)
        {
            return 0;
        }
        if(n%2 == 0)
        {
            for(int num : nums1) xor ^=num;
            return xor;
        }
        if(m%2 == 0)
        {
            for (int num : nums2) xor ^= num;
            return xor;
        }
        for (int num : nums1) xor ^= num;
        for (int num : nums2) xor ^= num;
        return xor;
    }
}