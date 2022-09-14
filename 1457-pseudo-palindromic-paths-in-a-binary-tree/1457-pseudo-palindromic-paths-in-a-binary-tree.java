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
     int count = 0;
      int[] n = new int[10];
     
    public int pseudoPalindromicPaths (TreeNode root) {
       
        Arrays.fill(n, 0);
        traverse_tree_dfs(root);
        return count;
            
    }
    public void traverse_tree_dfs(TreeNode root)
    {
        if(root == null) return;
        n[root.val]++;
        
        if(root.left == null && root.right == null)
        {
            int flag = 0;
            for(int i = 1; i<= 9; i++)
            {
                flag+=(n[i] %2);
            }
            if(flag == 1 || flag == 0) count++;
        }
        traverse_tree_dfs(root.left);
        traverse_tree_dfs(root.right);
        n[root.val]--;
    }
}