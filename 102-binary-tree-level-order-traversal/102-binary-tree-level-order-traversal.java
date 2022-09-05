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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            //System.out.println(n);
            List<Integer> a = new ArrayList<>();
            while(n-- > 0)
            {
                 TreeNode node = q.poll();
                 a.add(node.val);
                  //System.out.println(a);
                  if(node.left!=null)
                  {
                    q.add(node.left);
                  }
                 if(node.right!= null)
                 {
                   q.add(node.right);
                 }
            }
           list.add(a);
        }
       
        return list;
    }
}