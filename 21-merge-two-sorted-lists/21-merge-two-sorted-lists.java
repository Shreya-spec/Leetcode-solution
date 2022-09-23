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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode mergeList = new ListNode(-1);
        ListNode curr = mergeList;
        while(list1!=null || list2!=null)
        {
           if(list1 != null && list2!= null && list1.val<list2.val || list2 == null) 
           {
               curr.next = new ListNode(list1.val);
               list1 = list1.next;
           }
            else
            {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return mergeList.next;
    }
}