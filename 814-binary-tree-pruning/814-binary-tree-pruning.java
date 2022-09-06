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
    TreeNode first = null;
    public TreeNode pruneTree(TreeNode root) {
        TreeNode ans = inorder(root);
        return ans;
    }
    TreeNode inorder(TreeNode root)
    {
        if(root == null) return null;
        
        TreeNode left = inorder(root.left);
        if(left == null)
        {
            root.left = null;
        }
        TreeNode right = inorder(root.right);
         if(right == null)
        {
            root.right = null;
        }
        if((left == null && right == null && root.val == 0))
        {
           root = null;
            return null;
        }
        return root;
    }
}