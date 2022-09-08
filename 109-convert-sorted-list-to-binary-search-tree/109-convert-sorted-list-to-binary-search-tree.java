/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while(temp!=null)
        {
            list.add(temp.val);
         temp =  temp.next;  
        }
        int size = list.size();
         int[] a = new int[size];
       
        
        for(int i = 0; i<size; i++)
        {
            a[i] = list.get(i);
            
        }
        if(a.length == 0) return null;
       return helper(a, 0, a.length-1);
    }
    TreeNode helper(int[] a, int low, int high)
    {
        if(low>high) return null;
        int mid = low + (high - low)/2;
          //System.out.println(mid);
        TreeNode root = new TreeNode(a[mid]);
        root.left = helper(a, low, mid-1);
        root.right = helper(a, mid+1, high);
        return root;
    }
}