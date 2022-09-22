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
class Pair{
    int num;
    TreeNode node;
    Pair(TreeNode nd,int n){
        num=n;
        node=nd;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null)
            return ans;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int sz=q.size();
            int  mn=q.peek().num;
            int first=0,last=0;
            for(int i=0;i<sz;i++){
                Pair p=q.remove();
                int curr=p.num;
                TreeNode node=p.node;
                if(i==0)
                    first=curr;
                if(i==sz-1)
                    last=curr;
                if(node.left!=null){
                    q.offer(new Pair(node.left,2*curr+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,2*curr+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}