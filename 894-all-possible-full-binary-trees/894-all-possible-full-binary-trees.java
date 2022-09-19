/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List allPossibleFBT(int n) {

    List<TreeNode> ans=new ArrayList<>();
    if(n==1)
    {
        ans.add(new TreeNode(0));
    }else{
        n--;
        for(int i=1;i<n;i+=2)
        {
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(n-i);
            
            for(TreeNode lc:left)
            {
                for(TreeNode rc:right)
                {
                    TreeNode newchild=new TreeNode(0);
                    newchild.left=lc;
                    newchild.right=rc;
                    ans.add(newchild);
                }
            }
        }
    }
    return ans;
}
}