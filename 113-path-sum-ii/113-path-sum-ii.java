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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list =  new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        return calculation(root, targetSum, sub,list);
    }
    public List<List<Integer>> calculation(TreeNode root, int Sum, List<Integer> sub, List<List<Integer>> list)
    {
        if(root == null)
        {
            return list;
        }
        sub.add(root.val);
        if(root.left == null && root.right == null && Sum - root.val == 0)
        {
            list.add(new ArrayList<>(sub));
            sub.remove(sub.size() -1);
            return list;
        }
        else
        {
            calculation(root.left, Sum - root.val, sub, list);
            calculation(root.right, Sum - root.val, sub, list);
        }
        sub.remove(sub.size() -1);
        return list;
    }
}