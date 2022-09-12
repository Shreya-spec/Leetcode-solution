/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
      if(root==null) return null;
        //root.next = null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            Node prev = null;
            for(int i = 0; i<size; i++)
            {
                Node temp = q.poll();
                if(i == size-1)
                {
                temp.next = prev;
                }
                else
                {
                    temp.next = q.peek();
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
            }
        }
        return root;
    }
}