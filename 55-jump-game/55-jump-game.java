class Solution {
    public boolean canJump(int[] nums) {
        // keep updating the farthest index that can be reached from any current reachable index
        int maxInd = nums[0];
        for(int i = 1; i<nums.length; i++) {
            //cannot jump to this index if it exceeds out current max index to reach
            if(i>maxInd) {
                return false;
            }
            // otherwise this index can be reached, and we will update our max index to reach
            maxInd = Math.max(maxInd, i+nums[i]);
            if(maxInd>=nums.length-1) return true;
        }
        return true;
    }
}