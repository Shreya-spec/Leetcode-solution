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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        if(head == null)
        {
            return null;
        }
        while(temp!=null)
        {
            length++;
            temp = temp.next;
        }
        int deleteNode = 0;
        if(length>=n)
        {
        deleteNode = length - n;
        }
        else
        {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
         ListNode m = head;
        int count = 0;
        if(length == n)
        {
            return curr.next;
        }
        if(length != n)
        {
        while(curr != null)
        {
            
            if(deleteNode == count)
            {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }
        }
        /*while(m != null)
        {
           System.out.print(m.val+"->");
            m = m.next;
        }*/
        return head;
    }
}