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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
        {
            TreeNode newTreeNode = new TreeNode(val);
            newTreeNode.left = root;
            return newTreeNode;
        }
       
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int level = 1;
            while(!q.isEmpty())
            {
                int size = q.size();
                while(size-- > 0)
                {
                    //System.out.println(q.size());
                    TreeNode t = q.poll();
                    if(level == depth-1)
                    {
                        TreeNode newnode = new TreeNode(val);
                        newnode.left = t.left;
                        t.left = newnode;
                        
                        TreeNode newnode1 = new TreeNode(val);
                        newnode1.right = t.right;
                        t.right = newnode1;
                    }
                    if(t.left != null) q.offer(t.left);
                    if(t.right != null) q.offer(t.right);
                }
                level++;
            }
          return root;
    }
}