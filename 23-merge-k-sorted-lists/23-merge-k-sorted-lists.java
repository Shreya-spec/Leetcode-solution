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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode k1, ListNode k2)
            {
                if(k1.val>k2.val)
                    return 1;
                else if(k1.val < k2.val)
                {
                    return -1;
                }
                return 0;
            }
        });
        for(int i = 0; i<k; i++)
        {
            if(lists[i] != null)
            {
                pq.add(lists[i]);
            }
        }
        //System.out.println(pq);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(pq.size()>0)
        {
            ListNode temp = pq.poll();
            System.out.println(temp.val);
            tail.next = temp;
            tail = tail.next;
            //insert into queue
            if(tail.next!= null)
            {
                pq.add(tail.next);
            }
        }
        return head.next;
    }
}