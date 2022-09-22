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
    // To maintain max path
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getPathSum(root);
        return max;
    }
    
    private int getPathSum(TreeNode root){
        if(root==null) return 0;
              // If path have negavtive value no need to take that path. so we are using Max of with zero
        int lm = Math.max(0, getPathSum(root.left));
        int rm = Math.max(0, getPathSum(root.right));
       
        //  curve path
        //  Current node value + left subtree + right subtree
        max= Math.max(max, root.val + lm+rm);
        
        // Node can be junction. so while comming from parent we can go to only left subtree path or right subtree path. so curreValue + max (left or right) will return
        // return current value + Max of (left subtree or right subtree)
        return root.val + Math.max(lm, rm);
        
    }
}