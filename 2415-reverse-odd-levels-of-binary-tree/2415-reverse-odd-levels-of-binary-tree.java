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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            ++level;
            int size = q.size();
            TreeNode[] arr = new TreeNode[size];
            for(int i = 0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                arr[i] = curr;
            }
            if(level %2 != 0) reverse(arr);
        }
        return root;
    }
    void reverse(TreeNode[] arr)
    {
        for(int i = 0, j = arr.length-1; i<j; i++, j--)
        {
            int temp = arr[i].val;
            arr[i].val = arr[j].val;
            arr[j].val = temp;
        }
    }
}