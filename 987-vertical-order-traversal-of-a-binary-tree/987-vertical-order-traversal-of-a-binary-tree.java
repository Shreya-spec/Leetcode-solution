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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        vertical(root, map, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> vlevels : map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> hlevels : vlevels.values()){
                while(!hlevels.isEmpty())
                {
                    res.get(res.size()-1).add(hlevels.poll());
                }
            }
        }
        return res;
    }
    void vertical(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map,int vlevel, int hlevel)
    {
        if(root == null) return;
         if(!map.containsKey(vlevel)) map.put(vlevel, new TreeMap<>());
         if(!map.get(vlevel).containsKey(hlevel)) 
            map.get(vlevel).put(hlevel, new PriorityQueue<>());
          map.get(vlevel).get(hlevel).add(root.val);
        vertical(root.left, map, vlevel-1, hlevel+1);
        vertical(root.right, map, vlevel+1, hlevel+1);
    }
}