/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<List<Node>> q = new LinkedList<>();
       // Map<Integer, Node> map = new HashMap<>();
        List<Node> l1 = new ArrayList<>();
        List<List<Integer>> a = new ArrayList<>();
        l1.add(root);
        q.add(l1);
        while(!q.isEmpty())
        {
            List<Integer> m = new ArrayList<>();
            List<Node> h = new ArrayList<>();
              //System.out.println(q);
            List<Node> temp = q.poll();
           
            int n = temp.size();
            for(int i = 0; i<n; i++)
            {
                if(temp.get(i) != null)
                   m.add(temp.get(i).val);
              if(temp.get(i)!= null)  
              {
                if(!temp.get(i).children.isEmpty())
                 {
                    for(int j = 0; j<temp.get(i).children.size(); j++)
                    {
                      
                     h.add(temp.get(i).children.get(j));
                    }
                   
                    //q.add(temp.get(i).children);
                 }
              }
             
            }
            //System.out.println(h);
            //System.out.println(m);
            if(h.size()>0)
            q.add(h);
            a.add(m);
           
        }
        List<List<Integer>> k = new ArrayList<>();
          List<List<Integer>> b = new ArrayList<>();
        k.add(new ArrayList<>());
        //System.out.println(k);
        if(a.equals(k))
            return b;
         return a;
    }
}