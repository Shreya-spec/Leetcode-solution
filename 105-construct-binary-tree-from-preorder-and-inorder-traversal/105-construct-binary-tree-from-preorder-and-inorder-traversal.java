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
   public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = inorder.length;
    int[] idx = {0};
    return createTree(preorder, idx, inorder, 0, n);
}

public TreeNode createTree(int[] preorder, int[] idx, int[] inorder, int st, int en) {
    if(st == en)
        return null;        
    
    TreeNode root = new TreeNode(preorder[idx[0]]);
    
    for(int i=st; i<en; i++) {
        if(root.val == inorder[i]) {
            idx[0] += 1;
            root.left = createTree(preorder, idx, inorder, st, i);                
            root.right = createTree(preorder, idx, inorder, i+1, en);
            break;
        }
    }
    return root;
}
}