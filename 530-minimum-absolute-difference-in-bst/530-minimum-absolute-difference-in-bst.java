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
    public int getMinimumDifference(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> a = new ArrayList<>();
        if(root == null) return 0;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            a.add(temp.val);
            if(temp.left!= null)
            {
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                q.add(temp.right);
            }
        }
        Collections.sort(a);
       System.out.println(a);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<a.size()-1; i++)
        {
            if(ans > a.get(i+1) - a.get(i))
            {
                ans = a.get(i+1) - a.get(i);
            }
        }
        return ans;
    }
}