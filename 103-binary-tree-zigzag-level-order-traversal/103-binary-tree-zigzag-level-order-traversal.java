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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
       boolean flg = true;
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
             List<Integer> l = new ArrayList<>();
            
            while(n-- > 0)
            {
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left != null)
                {
                    q.add(node.left);
                }
                if(node.right != null)
                {
                    q.add(node.right);
                }
            }
            if(flg == true)
            {
            list.add(l);
                flg = false;
            }
            else
            {
                Collections.reverse(l);
                list.add(l);
                flg = true;
            }
        }
        return list;
    }
}