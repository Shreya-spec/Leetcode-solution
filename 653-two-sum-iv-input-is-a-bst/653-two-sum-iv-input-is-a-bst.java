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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        for(int i = 0, j = list.size()-1; i<j;)
        {
            if(list.get(i) + list.get(j) == k) return true;
            if(list.get(i) + list.get(j) < k)i++;
            else j --;
        }
        return false;
    }
    private void inorderTraversal(TreeNode root, List<Integer> list)
    {
    if(root == null ) return;
    inorderTraversal(root.left, list);
    list.add(root.val);
    inorderTraversal(root.right, list);
    }
}